package com.xan.abank_sample_frame.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<T extends ViewDataBinding,V extends ViewModel> extends DaggerAppCompatActivity {

    private T mViewDataBinding;
    private V mViewModel;

    public abstract int getBindingVariable();
    @LayoutRes
    protected abstract int getLayoutId();

    public abstract V getViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(layoutRes());
        performDataBinding();

    }
    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    private void performDataBinding() {
      mViewDataBinding = DataBindingUtil.setContentView(this,getLayoutId());
      this.mViewModel = mViewModel == null ? getViewModel():mViewModel;
      mViewDataBinding.setVariable(getBindingVariable(),mViewModel);
      mViewDataBinding.executePendingBindings();


    }
}
