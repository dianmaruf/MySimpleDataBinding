package com.android.indie.school.mysimpledatabinding.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.android.indie.school.mysimpledatabinding.MyApp;
import com.android.indie.school.mysimpledatabinding.R;
import com.android.indie.school.mysimpledatabinding.adapter.MyRecyclerViewAdapter;
import com.android.indie.school.mysimpledatabinding.base.BaseActivity;
import com.android.indie.school.mysimpledatabinding.databinding.ActivityMainBinding;
import com.android.indie.school.mysimpledatabinding.networking.Service;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel, MainActivityPresenter>
        implements MainActivityView {

    @Inject
    public Service service;

    @Override
    protected void initInjection() {
        ((MyApp) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void initViewModel() {
        viewModel = new MainActivityViewModel();
        binding.setViewModel(viewModel);
    }

    @Override
    protected void initPresenter() {
        presenter = new MainActivityPresenter(service);
        presenter.setView(this);
        presenter.setViewModel(binding.getViewModel());
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        initHandler();
    }

    private void initHandler() {
        MainActivityHandler handler = new MainActivityHandler();
        handler.setPresenter(presenter);
        binding.setHandler(handler);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populateData(List<String> emails) {
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(emails);
        binding.recycler.setAdapter(adapter);
    }

    @Override
    public void showProgress() {
        presenter.showProgressBar();
    }

    @Override
    public void hideProgress() {
        presenter.hideProgressBar();
    }

    @Override
    public void onSuccessFetchData(List<String> emails) {
        populateData(emails);
    }

    @Override
    public void onErrorFetchData(String errorMsg) {
        Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        presenter.onStop();
        super.onStop();
    }
}
