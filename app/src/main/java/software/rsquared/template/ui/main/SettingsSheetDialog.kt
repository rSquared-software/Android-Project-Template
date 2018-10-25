package software.rsquared.template.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import software.rsquared.template.R
import software.rsquared.template.databinding.SheetSettingsBinding
import software.rsquared.template.utils.ui.VmSheetDialogFragment

/**
 * @author Rafal Orlik
 */
class SettingsSheetDialog : VmSheetDialogFragment<MainViewModel>() {

	lateinit var binding: SheetSettingsBinding

	override val useActivityViewModel: Boolean = true

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		binding = DataBindingUtil.inflate(inflater, R.layout.sheet_settings, container, false)
		return binding.root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
	}
}