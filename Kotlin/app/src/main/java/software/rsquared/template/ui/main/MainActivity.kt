package software.rsquared.template.ui.main

import android.os.Bundle
import software.rsquared.template.R
import software.rsquared.template.databinding.ActivityMainBinding
import software.rsquared.template.ui.BaseVmActivity
import software.rsquared.template.utils.navigation.launchActivity

class MainActivity : BaseVmActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //where binding and vm are ready
    }
}
