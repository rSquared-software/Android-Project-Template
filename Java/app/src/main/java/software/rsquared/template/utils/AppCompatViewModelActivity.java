package software.rsquared.template.utils;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;

import software.rsquared.template.di.Injectable;

public abstract class AppCompatViewModelActivity<VM extends ViewModel> extends AppCompatActivity implements Injectable {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    protected AutoClearedValue<VM> binding;
    protected VM viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @SuppressWarnings("unchecked")
    private Class<VM> getViewModelType() {
        Class<VM> vmClass = (Class<VM>)
                ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
        return vmClass;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelType());
    }
}
