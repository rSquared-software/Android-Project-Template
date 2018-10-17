package software.rsquared.template.binding

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * @author Rafal Orlik
 */

@BindingAdapter("gone", "invisible", requireAll = false)
fun View.bindVisibility(gone: Boolean? = null, invisible: Boolean? = null) {
	val newVisibility = when {
		gone == true -> View.GONE
		invisible == true -> View.INVISIBLE
		else -> View.VISIBLE
	}
	if (visibility != newVisibility) {
		visibility = newVisibility
	}
}