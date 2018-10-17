package software.rsquared.template.ui

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import software.rsquared.template.utils.ui.ViewModelActivity

abstract class BaseVmActivity<VM : ViewModel, VDB : ViewDataBinding> : ViewModelActivity<VM>() {

    lateinit var binding: VDB

    abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
    }
}