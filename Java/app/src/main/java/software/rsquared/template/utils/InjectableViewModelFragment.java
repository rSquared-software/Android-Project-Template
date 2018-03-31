package software.rsquared.template.utils;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;

import software.rsquared.template.di.Injectable;

/**
 * @author rSquared.software
 */
public abstract class InjectableViewModelFragment<VM extends ViewModel> extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    protected VM viewModel;

    @SuppressWarnings("unchecked")
    private Class<VM> getViewModelType() {
        Class<VM> vmClass = (Class<VM>)
                ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
        return vmClass;
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
