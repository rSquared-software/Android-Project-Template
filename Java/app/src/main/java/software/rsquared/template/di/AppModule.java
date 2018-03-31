package software.rsquared.template.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import software.rsquared.template.utils.AppExecutors;

/**
 * @author rSquared.software
 */

@Module(includes = {ViewModelModule.class})
class AppModule {

    @Provides
    @Singleton
    Context provideAppContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    AppExecutors provideAppExecutors() {
        return new AppExecutors();
    }

}
