package com.lifesumtest.app.network;

import com.lifesumtest.app.models.ResponseModel;
import com.orhanobut.wasp.Callback;
import com.orhanobut.wasp.WaspRequest;
import com.orhanobut.wasp.http.EndPoint;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.Header;
import com.orhanobut.wasp.http.Path;

/**
 * Created by greymatter on 04/05/16.
 */
public interface NetworkService {

    @GET("/foods/en/se/{input}")
    WaspRequest searchFoodItems(@Header("Authorization") String authToken, @Path("input") String input, Callback<ResponseModel> callback);
}
