package software.rsquared.template.utils.navigation

import android.support.v4.app.Fragment

interface BackStackPolicy {

    fun addToBackStack(fragmentById: Fragment?): Boolean

}
