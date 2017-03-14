package com.android.indie.school.mysimpledatabinding.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by herisulistiyanto on 3/12/17.
 */

public class EmailViewModel extends BaseObservable{
    private String email;

    public EmailViewModel(String email) {
        this.email = email;
        setEmail(email);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
