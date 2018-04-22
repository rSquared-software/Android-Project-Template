package software.rsquared.template.utils.navigation

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

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

    protected fun open(@IdRes idRes: Int, fragment: Fragment, replacePolicy: ReplacePolicy, backStackPolicy: BackStackPolicy) {
        val fragmentById = fragmentManager.findFragmentById(idRes)
        if (fragmentById == null || replacePolicy.allowReplace(fragmentById)) {
            val transaction = fragmentManager.beginTransaction()

//            val sharedViews = extractSharedViews(fragmentById)
//            addSharedViewsToTransaction(transaction, sharedViews)

            if (backStackPolicy.addToBackStack(fragmentById)) {
                transaction.addToBackStack(null)
            }
            transaction.replace(idRes, fragment)
            transaction.setReorderingAllowed(true)
            transaction.commitAllowingStateLoss()
        } else {
            replacePolicy.onReplaceDenied(fragmentById)
        }
    }

//    private fun addSharedViewsToTransaction(transaction: FragmentTransaction, sharedViews: List<View>?) {
//        if (sharedViews != null) {
//            for (view in sharedViews) {
//                transaction.addSharedElement(view, ViewCompat.getTransitionName(view))
//            }
//        }
//    }
//
//    private fun extractSharedViews(fragmentById: Fragment?): List<View>? {
//        return if (fragmentById is HasTransitionViews) (fragmentById as HasTransitionViews).getTransitionViews() else null
//    }
}