package software.rsquared.template.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import software.rsquared.template.utils.AutoClearedValue
import software.rsquared.template.utils.ui.ViewModelActivity
import software.rsquared.template.utils.ui.ViewModelDialogFragment

abstract class BaseDialogFragment<VM : ViewModel, VDB : ViewDataBinding> : ViewModelDialogFragment<VM>() {

	lateinit var binding: AutoClearedValue<VDB>

	abstract val layoutRes: Int

//    open val dialogTheme: Int = R.style.AppTheme_Dialog

	var fragmentResult: Boolean = false

	var requestCode: Int = 0

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
		val dataBinding = DataBindingUtil.inflate<VDB>(LayoutInflater.from(context), layoutRes, null, false)
		binding = AutoClearedValue(this, dataBinding)
		val builder = AlertDialog.Builder(context!!).setView(dataBinding.root)
		buildDialog(builder, savedInstanceState)
		val dialog = builder.create()
		onDialogCreated(dialog, savedInstanceState)
		return dialog
	}

	protected open fun onDialogCreated(dialog: AlertDialog, savedInstanceState: Bundle?) {
	}

	abstract fun buildDialog(builder: AlertDialog.Builder, savedInstanceState: Bundle?)

	override fun setTargetFragment(fragment: Fragment?, requestCode: Int) {
		super.setTargetFragment(fragment, requestCode)
		this.fragmentResult = targetFragment != null
		this.requestCode = requestCode
	}

	fun setTargetActivity(requestCode: Int) {
		this.fragmentResult = false
		this.requestCode = requestCode
	}

	fun setResult(resultCode: Int, data: Intent) {
		if (fragmentResult) {
			targetFragment?.onActivityResult(requestCode, resultCode, data)
		} else if (activity is ViewModelActivity<*>) {
			(activity as ViewModelActivity<*>).onActivityResult(requestCode, resultCode, data)
		}
	}
}
