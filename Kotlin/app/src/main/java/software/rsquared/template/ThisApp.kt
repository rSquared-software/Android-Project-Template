package software.rsquared.template

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import software.rsquared.template.di.AppInjector
import javax.inject.Inject

class ThisApp : Application(), HasActivityInjector {

    var appInjector = AppInjector()

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()

        appInjector.init(this)
    }
}