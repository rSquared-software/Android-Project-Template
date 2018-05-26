package software.rsquared.template.utils.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import software.rsquared.template.di.Injectable
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

/**
 * An injectable activity with build in view model
 */
abstract class ViewModelActivity<VM : ViewModel> : FragmentActivity(), Injectable {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelType(): Class<VM> {
        return (javaClass
                .genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<VM>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[getViewModelType()]
    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

}