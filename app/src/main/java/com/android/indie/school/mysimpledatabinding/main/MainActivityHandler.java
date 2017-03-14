package com.android.indie.school.mysimpledatabinding.main;

/**
 * Created by herisulistiyanto on 3/12/17.
 */

public class MainActivityHandler {

    private MainActivityPresenter presenter;

    public MainActivityPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    public void fetchData() {
        presenter.getEmails();
    }
}
