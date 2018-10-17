package software.rsquared.template.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import software.rsquared.template.di.Injectable

abstract class BaseInjectableActivity : AppCompatActivity(), Injectable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}