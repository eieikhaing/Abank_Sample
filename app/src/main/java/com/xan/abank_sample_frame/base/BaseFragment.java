package com.xan.abank_sample_frame.base;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<T extends ViewDataBinding,V extends ViewModel> extends DaggerFragment {
    private AppCompatActivity activity;
    private T mViewDataBinding;
    private V mViewModel;
    View mRootView;
    private BaseActivity mActivity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        

    }

    protected abstract V getViewModel();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        mRootView = mViewDataBinding.getRoot();
        return mRootView;
    }

    @LayoutRes
    public abstract int getLayoutId();



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity)context;
    }
}
