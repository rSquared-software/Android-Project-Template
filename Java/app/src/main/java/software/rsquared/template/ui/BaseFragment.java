package software.rsquared.template.ui;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import software.rsquared.template.binding.ContextDataBindingComponent;
import software.rsquared.template.utils.AutoClearedValue;
import software.rsquared.template.utils.InjectableViewModelFragment;

/**
 * Created by rafalo on 17.11.2017.
 */

public abstract class BaseFragment<VM extends ViewModel, VDB extends ViewDataBinding> extends InjectableViewModelFragment<VM> {

    protected android.databinding.DataBindingComponent dataBindingComponent = new ContextDataBindingComponent(this);

    protected AutoClearedValue<VDB> binding;

    @Nullable
    @Override
    @CallSuper
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VDB dataBinding =
                DataBindingUtil.inflate(inflater, getLayoutRes(), container, false, dataBindingComponent);
        binding = new AutoClearedValue<>(this, dataBinding);
        binding.setOnClearListener(this::onBindingDestroy);
        return binding.get().getRoot();
    }

    protected void onBindingDestroy(VDB binding) {

    }

    @LayoutRes
    protected abstract int getLayoutRes();
}
