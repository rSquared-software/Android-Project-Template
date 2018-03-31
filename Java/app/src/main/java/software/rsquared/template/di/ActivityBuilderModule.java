package software.rsquared.template.di;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import software.rsquared.template.ui.main.MainActivity;

/**
 * @author rSquared.software
 */
@Module
abstract class ActivityBuilderModule {

//	@ContributesAndroidInjector(modules = {AuthFragmentsBuilder.class})
//	abstract AuthActivity bindAuthActivity();

	@ContributesAndroidInjector(modules = {MainFragmentsBuilder.class, MainActivityModule.class})
	abstract MainActivity bindMainActivity();

}
