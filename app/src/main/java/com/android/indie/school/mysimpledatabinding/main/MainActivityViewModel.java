package com.android.indie.school.mysimpledatabinding.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.android.indie.school.mysimpledatabinding.BR;

/**
 * Created by herisulistiyanto on 3/11/17.
 */

public class MainActivityViewModel extends BaseObservable{

    private int progressBarVisibility = View.GONE;

    @Bindable
    public int getProgressBarVisibility() {
        return progressBarVisibility;
    }

    public void setProgressBarVisibility(boolean isVisible) {
        this.progressBarVisibility = (isVisible) ? View.VISIBLE : View.GONE;
        notifyPropertyChanged(BR.progressBarVisibility);
    }
}
