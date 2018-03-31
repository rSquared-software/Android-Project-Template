package software.rsquared.template.utils;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * @author rSquared.software
 */

public class AutoClearedValue<T> {

    private OnClearListener<T> clearListener;

    private T value;

    public AutoClearedValue(Fragment fragment, T value) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.registerFragmentLifecycleCallbacks(
                    new FragmentManager.FragmentLifecycleCallbacks() {
                        @Override
                        public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {
                            if (f == fragment) {
                                destroy();
                                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                            }
                        }
                    }, false);
            this.value = value;
        }
    }

    private void destroy() {
        if (this.value instanceof Destroyable) {
            ((Destroyable) this.value).onDestroy();
        }
        if (clearListener != null) {
            clearListener.onClear(this.value);
        }
        this.value = null;
    }

    public void setOnClearListener(OnClearListener<T> clearListener) {
        this.clearListener = clearListener;
    }

    public AutoClearedValue(AppCompatActivity activity, T value) {
        Lifecycle lifecycle = activity.getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() {
            @Override
            public void onDestroy(@NonNull LifecycleOwner owner) {
                destroy();
                lifecycle.removeObserver(this);
            }
        });
        this.value = value;
    }

    public T get() {
        return value;
    }

    public interface Destroyable {
        void onDestroy();
    }

    public interface OnClearListener<T> {
        void onClear(T value);
    }
}