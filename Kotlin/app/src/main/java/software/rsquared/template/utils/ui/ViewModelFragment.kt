package software.rsquared.template.utils.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import software.rsquared.template.di.Injectable
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

/**
 * An injectable fragment with build in view model
 */
abstract class ViewModelFragment<VM : ViewModel> : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    internal lateinit var viewModel: VM

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelType(): Class<VM> {
        return (javaClass
                .genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<VM>
    }

    protected fun useActivityViewModel(): Boolean {
        return false
    }

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
                if (useActivityViewModel())
                    ViewModelProviders.of(this.activity!!, viewModelFactory)[getViewModelType()]
                else
                    ViewModelProviders.of(this, viewModelFactory)[getViewModelType()]
    }
}