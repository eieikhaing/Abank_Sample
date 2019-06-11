package com.xan.abank_sample_frame.di.module;

import com.xan.abank_sample_frame.ui.main.MainActivity;
import com.xan.abank_sample_frame.ui.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
