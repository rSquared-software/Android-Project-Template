package software.rsquared.template.di.main

import dagger.Module
import dagger.Provides
import software.rsquared.template.R
import software.rsquared.template.ui.main.MainActivity
import software.rsquared.template.ui.main.navigation.MainNavigationController
import software.rsquared.template.ui.main.navigation.MainPortraitNavigationController

@Module
class MainModule {

    @Provides
    fun provideNavigationController(activity: MainActivity): MainNavigationController {
        return if (activity.resources.getBoolean(R.bool.orientation_land)) {
            MainPortraitNavigationController(activity)//todo create land impl
        } else {
            MainPortraitNavigationController(activity)
        }

//        val land = activity.getResources().getBoolean(R.bool.land)
//        return if (land) {
//            MainLandNavigationController(activity)
//        } else {
//            MainPortraitNavigationController(activity)
//        }
//        return application
    }

}