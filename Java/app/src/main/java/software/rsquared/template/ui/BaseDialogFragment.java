package software.rsquared.template.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wooopit.restaurant.binding.ContextDataBindingComponent;
import com.wooopit.restaurant.di.Injectable;
import com.wooopit.restaurant.utils.AutoClearedValue;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;

/**
 * @author rSquared.software
 */

public abstract class BaseDialogFragment<VM extends ViewModel, VDB extends ViewDataBinding> extends DialogFragment implements Injectable {

	protected android.databinding.DataBindingComponent dataBindingComponent = new ContextDataBindingComponent(this);

	protected AutoClearedValue<VDB> binding;

	@Inject
	ViewModelProvider.Factory viewModelFactory;

	protected VM viewModel;

	@LayoutRes
	protected abstract int getLayoutRes();

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

	@SuppressWarnings("unchecked")
	private Class<VM> getViewModelType() {
		return (Class<VM>)
				((ParameterizedType) getClass()
						.getGenericSuperclass())
						.getActualTypeArguments()[0];
	}

	protected boolean useActivityViewModel() {
		return false;
	}

	@SuppressWarnings("ConstantConditions")
	@Override
	@CallSuper
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		viewModel = useActivityViewModel() ?
				ViewModelProviders.of(getActivity(), viewModelFactory).get(getViewModelType()) :
				ViewModelProviders.of(this, viewModelFactory).get(getViewModelType());
	}
}
