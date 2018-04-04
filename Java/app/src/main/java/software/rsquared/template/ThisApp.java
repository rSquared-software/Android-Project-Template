package software.rsquared.template;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;
import software.rsquared.template.di.AppComponent;
import software.rsquared.template.di.DaggerAppComponent;
import software.rsquared.template.di.Injectable;

public class ThisApp extends Application implements HasActivityInjector {

    //region activityInjector
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
    //endregion

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();

        //init other stuff
    }

    private void initDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
        appComponent.inject(this);
        registerActivityLifecycleCallbacks(new ActivityLifecycleInjector());
    }

    class ActivityLifecycleInjector implements Application.ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (activity instanceof HasSupportFragmentInjector || activity instanceof Injectable) {
                AndroidInjection.inject(activity);
            }
            if (activity instanceof FragmentActivity) {
                ((FragmentActivity) activity).getSupportFragmentManager()
                        .registerFragmentLifecycleCallbacks(
                                new FragmentManager.FragmentLifecycleCallbacks() {
                                    @Override
                                    public void onFragmentCreated(FragmentManager fm, Fragment f,
                                                                  Bundle savedInstanceState) {
                                        if (f instanceof Injectable) {
                                            AndroidSupportInjection.inject(f);
                                        }
                                    }
                                }, true);
            }
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

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
    }
}
