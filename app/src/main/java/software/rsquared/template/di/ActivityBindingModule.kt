package software.rsquared.template.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import software.rsquared.template.di.annotation.ActivityScoped
import software.rsquared.template.ui.main.MainActivity
import software.rsquared.template.ui.main.MainModule

@Module
internal abstract class ActivityBindingModule {

	@ActivityScoped
	@ContributesAndroidInjector(modules = [MainModule::class])
	internal abstract fun bindMainActivity(): MainActivity

}