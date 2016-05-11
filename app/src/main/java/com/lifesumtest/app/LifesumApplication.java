package com.lifesumtest.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import com.common.android.utils.ContextHelper;
import com.lifesumtest.app.utils.FontCache;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import static com.lifesumtest.app.utils.FontCache.UiLight;

public class LifesumApplication extends Application {
    final ActivityLifecycleCallbacks activityLifecycleCallbacks = createActivityCallBacks();

    private ActivityLifecycleCallbacks createActivityCallBacks() {
        return new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                setContext(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                setContext(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        };
    }

    private void setContext(Activity activity) {
        if (activity instanceof AppCompatActivity)
            ContextHelper.setContext((FragmentActivity) activity);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(UiLight.getResourcePath(getApplicationContext()))
                .setFontAttrId(R.attr.fontPath)
                .build());
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onTerminate() {
        unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        super.onTerminate();
    }
}
