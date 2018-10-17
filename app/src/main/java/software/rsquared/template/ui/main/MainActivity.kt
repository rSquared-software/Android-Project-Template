package software.rsquared.template.ui.main

import android.os.Bundle
import software.rsquared.template.R
import software.rsquared.template.databinding.ActivityMainBinding
import software.rsquared.template.ui.BaseVmActivity

class MainActivity : BaseVmActivity<MainViewModel, ActivityMainBinding>() {

	override val layoutRes: Int = R.layout.activity_main

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		//where binding and vm are ready
	}
}
