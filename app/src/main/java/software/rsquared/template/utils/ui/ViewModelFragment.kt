package software.rsquared.template.utils.ui

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import software.rsquared.permissiontools.Permissions
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

/**
 * An injectable fragment with build in view model
 */
abstract class ViewModelFragment<VM : ViewModel> : DaggerFragment() {

	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory

	protected lateinit var viewModel: VM

	@Suppress("UNCHECKED_CAST")
	private fun getViewModelType(): Class<VM> {
		return (javaClass
				.genericSuperclass as ParameterizedType)
				.actualTypeArguments[0] as Class<VM>
	}

	open val useActivityViewModel: Boolean = false

	@CallSuper
	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel =
				if (useActivityViewModel)
					ViewModelProviders.of(this.activity!!, viewModelFactory)[getViewModelType()]
				else
					ViewModelProviders.of(this, viewModelFactory)[getViewModelType()]
	}

	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)
		Permissions.onRequestPermissionsResult(requestCode, permissions, grantResults)
	}
}