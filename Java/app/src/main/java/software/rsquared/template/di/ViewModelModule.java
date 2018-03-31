package software.rsquared.template.di;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;

/**
 * @author rSquared.software
 */
@Module
abstract class ViewModelModule {

//	@Binds
//	@IntoMap
//	@ViewModelKey(LogInViewModel.class)
//	abstract ViewModel bindLogInViewModel(LogInViewModel logInViewModel);
//
//	@Binds
//	@IntoMap
//	@ViewModelKey(MainViewModel.class)
//	abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
