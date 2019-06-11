package com.xan.abank_sample_frame.ui.splash;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;
import com.xan.abank_sample_frame.R;
import com.xan.abank_sample_frame.base.BaseActivity;
import com.xan.abank_sample_frame.databinding.SplashLayoutBinding;
import com.xan.abank_sample_frame.ui.login.LoginActivity;
import com.xan.abank_sample_frame.utils.ViewModelFactory;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<SplashLayoutBinding, SplashViewModel>implements
        SplashNavigator   {
    @Inject
    ViewModelFactory viewModelFactory;
    private SplashViewModel splashViewModel;

    public static Intent newIntent(Context context){
        return new Intent(context,SplashActivity.class);
    }
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.splash_layout;
    }

    @Override
    public SplashViewModel getViewModel() {
        splashViewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel.class);
        return splashViewModel;
    }
    public void openLoginActivity(){
        Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel.setNavigator(this);
    }
}
