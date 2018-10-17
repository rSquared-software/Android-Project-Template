package software.rsquared.template.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import software.rsquared.template.utils.ui.ViewModelActivity

abstract class BaseVmActivity<VM : ViewModel, VDB : ViewDataBinding> : ViewModelActivity<VM>() {

	lateinit var binding: VDB

	abstract val layoutRes: Int

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, layoutRes)
	}
}