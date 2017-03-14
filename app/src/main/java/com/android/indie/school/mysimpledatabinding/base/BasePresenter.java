package com.android.indie.school.mysimpledatabinding.base;

/**
 * Created by herisulistiyanto on 3/11/17.
 */

public class BasePresenter<V, VM> {

    protected V view;
    protected VM viewModel;

    public void setView(V view) {
        this.view = view;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
    }
}
