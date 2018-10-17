package software.rsquared.template.ui.main.navigation

import software.rsquared.template.ui.main.MainActivity
import software.rsquared.template.utils.navigation.BaseNavigationController

class MainPortraitNavigationController constructor(activity: MainActivity) : BaseNavigationController(activity), MainNavigationController {

    override fun goBack(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cleanup() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}