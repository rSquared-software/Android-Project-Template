package software.rsquared.template.utils.ui

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * An injectable activity with view model and fragment ready
 * @author rSquared.Software
 */
abstract class ViewModelFragmentActivity<VM : ViewModel> : ViewModelActivity<VM>(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }

}