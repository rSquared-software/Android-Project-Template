package software.rsquared.template

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import software.rsquared.template.di.AppInjector
import software.rsquared.template.di.AppInjectorImpl
import javax.inject.Inject

class ThisApp : Application(), HasActivityInjector {

    companion object {
        val appInjector: AppInjector = AppInjectorImpl()
        lateinit var instance: ThisApp
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        instance = this
        appInjector.inject(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
//        MultiDex.install(this)
    }
}