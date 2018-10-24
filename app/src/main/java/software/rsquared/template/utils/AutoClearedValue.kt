package software.rsquared.template.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class AutoClearedValue<T>(fragment: Fragment, var value: T?) {

	init {
		fragment.fragmentManager?.registerFragmentLifecycleCallbacks(
				object : FragmentManager.FragmentLifecycleCallbacks() {
					override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
						super.onFragmentViewDestroyed(fm, f)
						if (f === fragment) {
							value = null
							fragment.fragmentManager?.unregisterFragmentLifecycleCallbacks(this)
						}
					}
				}, false)
	}
}