package software.rsquared.template.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import software.rsquared.template.ThisApp

/**
 * @author Rafal Orlik
 */
@Module(includes = [])
internal class AppModule {

	@Provides
	fun provideAppContext(application: ThisApp): Context {
		return application
	}

	@Provides
	fun provideApplication(application: ThisApp): Application {
		return application
	}

}