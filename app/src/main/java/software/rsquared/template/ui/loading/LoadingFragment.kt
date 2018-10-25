package software.rsquared.template.ui.loading

import android.os.Bundle
import software.rsquared.template.R
import software.rsquared.template.databinding.FragmentLoadingBinding
import software.rsquared.template.ui.BaseFragment

/**
 * @author Rafal Orlik
 */
class LoadingFragment : BaseFragment<LoadingViewModel, FragmentLoadingBinding>() {

	override val layoutRes: Int = R.layout.fragment_loading

	override fun bindViewModel(dataBinding: FragmentLoadingBinding) {
		dataBinding.viewModel = viewModel
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
	}
}