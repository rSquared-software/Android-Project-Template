package software.rsquared.template.utils.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import software.rsquared.permissiontools.Permissions
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

/**
 * An injectable activity with build in view model
 */
abstract class ViewModelActivity<VM : ViewModel> : DaggerAppCompatActivity() {

	init {
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
	}

	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory

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

	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)
		Permissions.onRequestPermissionsResult(requestCode, permissions, grantResults)
	}
}