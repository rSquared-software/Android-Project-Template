package software.rsquared.template.di;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import software.rsquared.template.ui.main.SampleFragment.SampleFragment;

/**
 * @author rSquared.software
 */
@Module
abstract class MainFragmentsBuilder {

    @ContributesAndroidInjector
    abstract SampleFragment contributeSampleFragment();

}
