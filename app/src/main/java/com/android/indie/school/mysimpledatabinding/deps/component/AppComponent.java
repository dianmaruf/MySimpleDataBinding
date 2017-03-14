package com.android.indie.school.mysimpledatabinding.deps.component;

import com.android.indie.school.mysimpledatabinding.deps.module.NetworkModule;
import com.android.indie.school.mysimpledatabinding.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by herisulistiyanto on 3/12/17.
 */
@Singleton
@Component(modules = {
        NetworkModule.class
})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
