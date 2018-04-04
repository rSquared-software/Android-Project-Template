package software.rsquared.template.utils.ui;

import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class AppCompatVmSupportFragmentInjectorActivity<VM extends ViewModel> extends AppCompatViewModelActivity<VM> implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
