package software.rsquared.template.utils.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

inline fun <reified T : Any> Activity.launchActivity(
        requestCode: Int = -1,
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}) {

    val intent = newIntent<T>(this)
    intent.init()
    startActivityForResult(intent, requestCode, options)
}

inline fun <reified T : Any> Context.launchActivity(
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}) {

    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent, options)
}

inline fun <reified T : Any> android.support.v4.app.Fragment.launchActivity(
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}) {
    if (context != null) {
        val intent = newIntent<T>(context as Context)
        intent.init()
        startActivity(intent, options)
    }
}

inline fun <reified T : Any> android.support.v4.app.Fragment.launchActivity(
        requestCode: Int = -1,
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}) {
    if (context != null) {
        val intent = newIntent<T>(context as Context)
        intent.init()
        startActivityForResult(intent, requestCode, options)
    }
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)