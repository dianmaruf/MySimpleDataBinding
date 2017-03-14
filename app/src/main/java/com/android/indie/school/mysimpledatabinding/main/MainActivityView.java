package com.android.indie.school.mysimpledatabinding.main;

import java.util.List;

/**
 * Created by herisulistiyanto on 3/11/17.
 */

public interface MainActivityView {

    void showProgress();

    void hideProgress();

    void onSuccessFetchData(List<String> emails);

    void onErrorFetchData(String errorMsg);

}
