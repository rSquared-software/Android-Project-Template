package software.rsquared.template.ui

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import software.rsquared.template.utils.AutoClearedValue
import software.rsquared.template.utils.ui.ViewModelFragment

abstract class BaseFragment<VM : ViewModel, VDB : ViewDataBinding> : ViewModelFragment<VM>() {

    lateinit var binding: AutoClearedValue<VDB>

    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val dataBinding = DataBindingUtil.inflate<VDB>(inflater, getLayoutRes(), container, false, dataBindingComponent)
        val dataBinding = DataBindingUtil.inflate<VDB>(inflater, getLayoutRes(), container, false)
        binding = AutoClearedValue(this, dataBinding)
        return dataBinding.root
    }
}