package com.android.indie.school.mysimpledatabinding.main;

import com.android.indie.school.mysimpledatabinding.base.BasePresenter;
import com.android.indie.school.mysimpledatabinding.networking.Service;

import java.util.List;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by herisulistiyanto on 3/11/17.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityView, MainActivityViewModel> {

    private Service service;
    private CompositeSubscription subscriptions;

    public MainActivityPresenter(Service service) {
        this.service = service;
        this.subscriptions = new CompositeSubscription();
    }

    public void showProgressBar() {
        viewModel.setProgressBarVisibility(true);
    }

    public void hideProgressBar() {
        viewModel.setProgressBarVisibility(false);
    }

    public void getEmails() {
        view.showProgress();
        final Subscription subscription = service.getEmails(new Service.GetEmailsCallback() {
            @Override
            public void onSuccess(List<String> emails) {
                view.hideProgress();
                view.onSuccessFetchData(emails);
            }

            @Override
            public void onError(String errorMsg) {
                view.hideProgress();
                view.onErrorFetchData(errorMsg);
            }
        });
        subscriptions.add(subscription);
    }

    public void onStop() {
        if (!subscriptions.isUnsubscribed()) {
            subscriptions.clear();
        }
    }
}
