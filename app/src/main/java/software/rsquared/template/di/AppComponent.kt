package software.rsquared.template.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import software.rsquared.template.ThisApp
import javax.inject.Singleton

/**
 * @author Rafal Orlik
 */
@Singleton
@Component(modules = [
	AndroidSupportInjectionModule::class,
	AppModule::class,
	ActivityBindingModule::class,
	ViewModelModule::class
])
interface AppComponent : AndroidInjector<ThisApp> {
	@Component.Builder
	abstract class Builder : AndroidInjector.Builder<ThisApp>()
}