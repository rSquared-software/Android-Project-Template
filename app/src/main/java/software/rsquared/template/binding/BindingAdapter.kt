package software.rsquared.template.binding

import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import software.rsquared.androidlogger.Logger

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

@BindingAdapter("progress")
fun ProgressBar.bindProgress(value: Int?) {

	class ProgressAnim(val from: Float, val to: Float) : Animation() {

		constructor(from: Int, to: Int) : this(from.toFloat(), to.toFloat())

		init {
			Logger.debug("from=$from, to=$to")
			duration = 500
		}

		override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
			progress = (from + ((to - from) * interpolatedTime)).toInt()
		}
	}


	if (value != null && value > progress) {
		startAnimation(ProgressAnim(progress, value))
	} else {
		progress = 0
	}
}