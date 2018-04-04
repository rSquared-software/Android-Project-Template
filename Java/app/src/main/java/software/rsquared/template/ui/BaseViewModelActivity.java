package software.rsquared.template.ui;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import software.rsquared.template.binding.ContextDataBindingComponent;
import software.rsquared.template.utils.ui.AppCompatViewModelActivity;
import software.rsquared.template.utils.AutoClearedValue;

/**
 * @author rSquared.software
 */

public abstract class BaseViewModelActivity<VM extends ViewModel, VDB extends ViewDataBinding> extends AppCompatViewModelActivity<VM> {

    protected android.databinding.DataBindingComponent dataBindingComponent = new ContextDataBindingComponent(this);

    protected AutoClearedValue<VDB> binding;

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//		if (getResources().getBoolean(R.bool.portrait_only)) {
//			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//		}
        super.onCreate(savedInstanceState);
        binding = new AutoClearedValue<>(this, DataBindingUtil.setContentView(this, getLayoutRes(), dataBindingComponent));
    }
}
