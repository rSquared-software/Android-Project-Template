package software.rsquared.template.ui

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import software.rsquared.template.utils.ui.VmActivity

abstract class BaseActivity<VM : ViewModel, VDB : ViewDataBinding> : VmActivity<VM>() {

    lateinit var binding: VDB

    abstract val layoutRes: Int

    abstract fun bindViewModel(binding: VDB)

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        bindViewModel(binding)
        binding.setLifecycleOwner(this)
    }
}