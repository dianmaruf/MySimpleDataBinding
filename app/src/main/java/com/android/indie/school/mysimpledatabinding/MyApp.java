package com.android.indie.school.mysimpledatabinding;

import android.app.Application;

import com.android.indie.school.mysimpledatabinding.deps.component.AppComponent;
import com.android.indie.school.mysimpledatabinding.deps.component.DaggerAppComponent;
import com.android.indie.school.mysimpledatabinding.deps.module.NetworkModule;

/**
 * Created by herisulistiyanto on 3/12/17.
 */

public class MyApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setAppComponent(DaggerAppComponent.builder()
                .networkModule(new NetworkModule(getApplicationContext().getString(R.string.base_url)))
                .build());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
