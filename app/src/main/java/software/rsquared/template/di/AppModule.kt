package software.rsquared.template.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Rafal Orlik
 */
@Module(includes = [ViewModelModule::class])
internal class AppModule {

    @Provides
    @Singleton
    fun provideAppContext(application: Application): Context {
        return application
    }

}