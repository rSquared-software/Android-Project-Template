package software.rsquared.template.binding

import android.databinding.BindingAdapter
import android.databinding.DataBindingComponent
import android.support.annotation.ColorRes
import android.view.View

/**
 * @author Rafal Orlik
 */
class BindingAdapter : DataBindingComponent {

    override fun getBindingAdapter(): software.rsquared.template.binding.BindingAdapter {
        return this
    }

    @BindingAdapter("visible")
    fun bindVisible(view: View, show: Boolean) {
        val visibility = if (show) View.VISIBLE else View.GONE
        if (view.visibility != visibility) {
            view.visibility = visibility
        }
    }

    @BindingAdapter("invisible")
    fun bindInvisible(view: View, hide: Boolean) {
        val visibility = if (hide) View.INVISIBLE else View.VISIBLE
        if (view.visibility != visibility) {
            view.visibility = visibility
        }
        view.isEnabled = !hide
    }

    @BindingAdapter("gone")
    fun bindGone(view: View, gone: Boolean) {
        val visibility = if (gone) View.GONE else View.INVISIBLE
        if (view.visibility != visibility) {
            view.visibility = visibility
        }
    }

    @BindingAdapter("rotation")
    fun bindRotation(view: View, rotation: Float) {
        view.rotation = rotation
    }

    @BindingAdapter("backgroundColor")
    fun bindViewBackgroundColorRes(view: View, @ColorRes colorRes: Int) {
        view.setBackgroundResource(colorRes)
    }


}