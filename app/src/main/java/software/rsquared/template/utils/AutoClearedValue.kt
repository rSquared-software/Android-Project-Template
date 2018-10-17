package software.rsquared.template.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class AutoClearedValue<T>(fragment: Fragment, var value: T?) {

    init {
        fragment.fragmentManager?.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentViewDestroyed(fm: FragmentManager?, f: Fragment?) {
                        if (f === fragment) {
                            value = null
                            fragment.fragmentManager?.unregisterFragmentLifecycleCallbacks(this)
                        }
                    }
                }, false)
    }
}