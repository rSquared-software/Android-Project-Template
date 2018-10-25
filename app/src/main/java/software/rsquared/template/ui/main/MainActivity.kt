package software.rsquared.template.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.sheet_menu.*
import software.rsquared.androidlogger.Logger
import software.rsquared.template.R
import software.rsquared.template.databinding.ActivityMainBinding
import software.rsquared.template.ui.BaseActivity
import software.rsquared.template.ui.loading.LoadingFragment

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

	override val layoutRes: Int = R.layout.activity_main

	override fun bindViewModel(binding: ActivityMainBinding) {
		binding.viewModel = viewModel
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
					.add(R.id.content, LoadingFragment())
					.commit()
		}

		binding.bar.setNavigationOnClickListener {
			Logger.debug("setNavigationOnClickListener ")
			MenuSheet().apply {
				openSettings = {
					SettingsSheetDialog().show(supportFragmentManager, "menu")
				}
			}.show(supportFragmentManager, "menu")
		}

//		viewModel.postResult()

		//where binding and vm are ready
	}

	class MenuSheet : BottomSheetDialogFragment() {

		var openSettings: (() -> Unit)? = null

		override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
			return inflater.inflate(R.layout.sheet_menu, container, false)
		}

		override fun onActivityCreated(savedInstanceState: Bundle?) {
			super.onActivityCreated(savedInstanceState)
			navigation_view.setNavigationItemSelectedListener {
				Logger.debug("clicked ${it.title}")
				when (it.itemId) {
					R.id.nav2 -> {
						openSettings?.invoke()
					}
				}
//				dismiss()
				true
			}
		}
	}
}
