package software.rsquared.template.utils.ui

import android.content.Context
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

/**
 * @author Rafal Orlik
 */
abstract class VmSheetDialogFragment<VM : ViewModel> : BottomSheetDialogFragment(), HasSupportFragmentInjector {

	//region Dagger part
	@Inject
	lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

	@CallSuper
	override fun onAttach(activity: Context?) {
		AndroidSupportInjection.inject(this)
		super.onAttach(activity)
	}

	override fun supportFragmentInjector(): AndroidInjector<Fragment> {
		return childFragmentInjector
	}
	//endregion

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
}