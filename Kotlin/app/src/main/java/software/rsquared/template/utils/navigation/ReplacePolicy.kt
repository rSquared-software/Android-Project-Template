package software.rsquared.template.utils.navigation

import android.support.v4.app.Fragment

interface ReplacePolicy {

    fun allowReplace(fragment: Fragment): Boolean

    fun onReplaceDenied(fragmentById: Fragment?)
}