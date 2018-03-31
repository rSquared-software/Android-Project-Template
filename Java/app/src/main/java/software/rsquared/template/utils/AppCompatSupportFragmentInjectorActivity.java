package software.rsquared.template.utils;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * @author rSquared.software
 */

public abstract class AppCompatSupportFragmentInjectorActivity extends AppCompatActivity implements HasSupportFragmentInjector {

	static {
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}

	@Inject
	DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


	@Override
	public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
		return dispatchingAndroidInjector;
	}
}
