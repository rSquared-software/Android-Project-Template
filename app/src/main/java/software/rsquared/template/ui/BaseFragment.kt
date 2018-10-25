package software.rsquared.template.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import software.rsquared.template.utils.AutoClearedValue
import software.rsquared.template.utils.ui.VmFragment

abstract class BaseFragment<VM : ViewModel, VDB : ViewDataBinding> : VmFragment<VM>() {

	lateinit var binding: AutoClearedValue<VDB>

	abstract val layoutRes: Int

	abstract fun bindViewModel(dataBinding: VDB)

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val dataBinding = DataBindingUtil.inflate<VDB>(inflater, layoutRes, container, false)
		dataBinding.setLifecycleOwner(this)
		binding = AutoClearedValue(this, dataBinding)
		return dataBinding.root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		binding.value?.apply { bindViewModel(this) }

	}
}