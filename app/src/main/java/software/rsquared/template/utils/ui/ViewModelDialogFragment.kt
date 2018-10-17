package software.rsquared.template.utils.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import software.rsquared.template.di.Injectable
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

/**
 * An injectable fragment with build in view model
 */
abstract class ViewModelDialogFragment<VM : ViewModel> : DialogFragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    open val useActivityViewModel : Boolean = false

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelType(): Class<VM> {
        return (javaClass
                .genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<VM>
    }

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
                if (useActivityViewModel)
                    ViewModelProviders.of(this.activity!!, viewModelFactory)[getViewModelType()]
                else
                    ViewModelProviders.of(this, viewModelFactory)[getViewModelType()]
    }
}