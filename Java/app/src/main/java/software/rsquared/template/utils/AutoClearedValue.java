package software.rsquared.template.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

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
        if (clearListener != null) {
            clearListener.onClear(this.value);
        }
        this.value = null;
    }

    public void setOnClearListener(OnClearListener<T> clearListener) {
        this.clearListener = clearListener;
    }

    public T get() {
        return value;
    }

    public interface OnClearListener<T> {
        void onClear(T value);
    }
}