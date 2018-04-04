package software.rsquared.template.binding;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Spinner;

/**
 * Created by rafalo on 16.11.2017.
 */
public class ContextBindingAdapters {

    private final Activity activity;
    private final Fragment fragment;

    public ContextBindingAdapters(Fragment fragment) {
        this.activity = null;
        this.fragment = fragment;
    }

    public ContextBindingAdapters(Activity activity) {
        this.activity = activity;
        this.fragment = null;
    }

    private Context getContext() {
        if (fragment != null) {
            return fragment.getContext();
        }
        return activity;
    }

    //here put some binding methods that requires context, e.g. when using Glide


}
