package com.lifesumtest.app.network;

import android.support.annotation.NonNull;
import android.webkit.WebView;
import com.common.android.utils.interfaces.ICallback;
import com.lifesumtest.app.Environment;
import com.lifesumtest.app.R;
import com.lifesumtest.app.models.ResponseModel;
import com.lifesumtest.app.network.error.ErrorHandler;
import com.orhanobut.wasp.*;
import com.orhanobut.wasp.utils.NetworkMode;

import java.net.CookiePolicy;

import static com.common.android.utils.ContextHelper.getContext;

/**
 * Created by greymatter on 04/05/16.
 */
public class RequestProvider {

    private static final boolean MOCK_NETWORK = false;
    private static NetworkService service;

    @NonNull
    private static RemoteRequestInterceptor createRemoteRequestInterceptor() {
        return new RemoteRequestInterceptor();
    }

    private static NetworkService networkService() {
        if (service == null)
            service = createNetworkService(createRemoteRequestInterceptor());
        return service;
    }

    private static NetworkService createNetworkService(RemoteRequestInterceptor interceptor) {
        return new Wasp.Builder(getContext())
                .setEndpoint(Environment.active.baseUrl)
                .setNetworkMode(MOCK_NETWORK
                        ? NetworkMode.MOCK
                        : NetworkMode.LIVE)
                .enableCookies(CookiePolicy.ACCEPT_ALL)
                .setRequestInterceptor(interceptor)
                .build()
                .create(NetworkService.class);
    }

    public static WaspRequest searchFoodItems(@NonNull final  String input, final ICallback callback){
        return networkService().searchFoodItems("5055538:e52b2981d949fea96d3a103643f377e1ab85c08e347e310adf5ed927831e1018", input, new Callback<ResponseModel>(){
            @Override
            public void onSuccess(Response response, ResponseModel responseModel) {
            callback.onSuccess(responseModel);
            }

            @Override
            public void onError(WaspError waspError) {
                ErrorHandler.handleWaspError(waspError);
            }
        });
    }
}
