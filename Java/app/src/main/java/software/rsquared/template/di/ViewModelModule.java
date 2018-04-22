package software.rsquared.template.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import software.rsquared.template.ui.simple.SampleFragment.SampleViewModel;
import software.rsquared.template.ui.pager.PagerViewModel;

/**
 * @author rSquared.software
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PagerViewModel.class)
    abstract ViewModel bindPagerViewModel(PagerViewModel pagerViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel.class)
    abstract ViewModel bindSampleViewModel(SampleViewModel sampleViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
