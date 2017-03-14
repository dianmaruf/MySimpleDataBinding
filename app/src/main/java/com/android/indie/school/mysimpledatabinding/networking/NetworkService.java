package com.android.indie.school.mysimpledatabinding.networking;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by herisulistiyanto on 3/12/17.
 */

public interface NetworkService {

    @GET("emails")
    Observable<List<String>> getEmails();

}
