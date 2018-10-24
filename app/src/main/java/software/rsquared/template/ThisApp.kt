package software.rsquared.template

import android.content.Context
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ThisApp : DaggerApplication() {

	override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
		TODO("uncomment")
//		return DaggerAppComponent.builder().create(this)
	}

	override fun attachBaseContext(base: Context) {
		super.attachBaseContext(base)
		MultiDex.install(this)
	}
}