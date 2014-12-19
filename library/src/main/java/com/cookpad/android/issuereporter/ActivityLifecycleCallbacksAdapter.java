package com.cookpad.android.issuereporter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class ActivityLifecycleCallbacksAdapter implements Application.ActivityLifecycleCallbacks {
    private ActivityCreatedCallback callback;

    public ActivityLifecycleCallbacksAdapter(Application application, ActivityCreatedCallback callback) {
        application.registerActivityLifecycleCallbacks(this);
        this.callback = callback;
    }

    public void destroy(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        callback.onCreated(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    public static interface ActivityCreatedCallback {
        public void onCreated(Activity activity);
    }
}

