package software.rsquared.template.ui

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import software.rsquared.template.utils.ui.ViewModelFragmentActivity

abstract class BaseVmFragmentActivity<VM : ViewModel, VDB : ViewDataBinding> : ViewModelFragmentActivity<VM>() {

    lateinit var binding: VDB

    abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)

    }
}