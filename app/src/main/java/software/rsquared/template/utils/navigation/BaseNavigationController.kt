package software.rsquared.template.utils.navigation

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View

abstract class BaseNavigationController constructor(activity: FragmentActivity) : NavigationController {

    private val fragmentManager = activity.supportFragmentManager

    protected fun clearBackStack() {
        if (fragmentManager.backStackEntryCount > 0) {
            val first = fragmentManager.getBackStackEntryAt(0)
            try {
                fragmentManager.popBackStackImmediate(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            } catch (e: IllegalStateException) {

            }
        }
    }

    protected fun open(@IdRes idRes: Int, fragment: Fragment, addToBackStack: (Fragment?) -> Boolean, allowReplace: (Fragment?) -> Boolean, onReplaceDenied: (Fragment?) -> Unit) {
        val fragmentById: Fragment? = fragmentManager.findFragmentById(idRes)
        if (fragmentById == null || allowReplace(fragmentById)) {
            val transaction = fragmentManager.beginTransaction()

            if (fragmentById is ContainsTransitionViews) {
                transaction.addSharedElements(fragmentById.getTransitionViews())
            }

            if (addToBackStack(fragmentById)) {
                transaction.addToBackStack(null)
            }
            transaction.replace(idRes, fragment)
            transaction.setReorderingAllowed(true)
            transaction.commitAllowingStateLoss()
        } else {
            onReplaceDenied(fragmentById)
        }
    }

    private fun FragmentTransaction.addSharedElements(views: List<View>) {
        views.forEach {
            this.addSharedElement(it, android.support.v4.view.ViewCompat.getTransitionName(it))
        }
    }
}