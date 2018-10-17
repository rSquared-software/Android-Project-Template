package software.rsquared.template.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import software.rsquared.template.utils.AutoClearedValue
import software.rsquared.template.utils.ui.ViewModelFragment

abstract class BaseFragment<VM : ViewModel, VDB : ViewDataBinding> : ViewModelFragment<VM>() {

	lateinit var binding: AutoClearedValue<VDB>

	abstract val layoutRes: Int

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val dataBinding = DataBindingUtil.inflate<VDB>(inflater, layoutRes, container, false)
		binding = AutoClearedValue(this, dataBinding)
		return dataBinding.root
	}
}