package software.rsquared.template.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.ColorRes;
import android.view.View;

public class BindingAdapters {

    @BindingAdapter("visible")
    public static void bindVisible(View view, boolean show) {
        int visibility = show ? View.VISIBLE : View.GONE;
        if (view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
    }

    @BindingAdapter("invisible")
    public static void bindInvisible(View view, boolean hide) {
        int visibility = hide ? View.INVISIBLE : View.VISIBLE;
        if (view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
        view.setEnabled(!hide);
    }

    @BindingAdapter("gone")
    public static void bindGone(View view, boolean gone) {
        int visibility = gone ? View.GONE : View.INVISIBLE;
        if (view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
    }

    @BindingAdapter("rotation")
    public static void bindRotation(View view, float rotation) {
        view.setRotation(rotation);
    }

    @BindingAdapter("backgroundColor")
    public static void bindViewBackgroundColorRes(View view, @ColorRes int colorRes) {
        view.setBackgroundResource(colorRes);
    }
}
