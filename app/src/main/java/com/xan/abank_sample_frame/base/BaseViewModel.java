
package com.xan.abank_sample_frame.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;


import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseViewModel<N> extends ViewModel {

  private final ObservableBoolean mIsLoading = new ObservableBoolean(false);
   private CompositeDisposable mCompositeDisposable;

  private WeakReference<N> mNavigator;

  public BaseViewModel() {

    this.mCompositeDisposable = new CompositeDisposable();
  }

  @Override
  protected void onCleared() {
    mCompositeDisposable.dispose();
    super.onCleared();
  }

  public CompositeDisposable getCompositeDisposable() {
    return mCompositeDisposable;
  }



  public ObservableBoolean getIsLoading() {
    return mIsLoading;
  }

  public void setIsLoading(boolean isLoading) {
    mIsLoading.set(isLoading);
  }

  public N getNavigator() {
    return mNavigator.get();
  }

  public void setNavigator(N navigator) {
    this.mNavigator = new WeakReference<>(navigator);
  }


}
