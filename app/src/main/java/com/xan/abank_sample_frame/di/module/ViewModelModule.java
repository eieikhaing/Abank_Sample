package com.xan.abank_sample_frame.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.xan.abank_sample_frame.di.util.ViewModelKey;
import com.xan.abank_sample_frame.ui.login.LoginViewModel;
import com.xan.abank_sample_frame.ui.splash.SplashViewModel;
import com.xan.abank_sample_frame.utils.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    abstract ViewModel bindListViewModel(SplashViewModel listViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindDetailsViewModel(LoginViewModel detailsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
