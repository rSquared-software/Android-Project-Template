package software.rsquared.template.ui;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import software.rsquared.template.binding.ContextDataBindingComponent;
import software.rsquared.template.di.Injectable;
import software.rsquared.template.utils.AutoClearedValue;
import software.rsquared.template.utils.ui.AppCompatVmSupportFragmentInjectorActivity;

/**
 * @author rSquared.software
 */

public abstract class BaseVmFragmentActivity<VM extends ViewModel, VDB extends ViewDataBinding> extends AppCompatVmSupportFragmentInjectorActivity<VM> implements Injectable {

    protected android.databinding.DataBindingComponent dataBindingComponent = new ContextDataBindingComponent(this);

    protected AutoClearedValue<VDB> binding;

    @LayoutRes
    protected abstract int getLayoutRes();

//	private AlertDialog updateDialog;

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//		if (getResources().getBoolean(R.bool.portrait_only)) {
//			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//		}
        super.onCreate(savedInstanceState);
        binding = new AutoClearedValue<>(this, DataBindingUtil.setContentView(this, getLayoutRes(), dataBindingComponent));

//		userService.getAuth().observe(this, auth -> {
//			if (auth != null) {
//				if (auth.status == Auth.Status.NOT_AUTHORIZED) {
//					Logger.info("onCreate: user not logged - open log in activity");
//					NotificationUtils.cancelAllNotifications(this);
//					openLogInActivity();
//				} else if (auth.status == Auth.Status.CACHED) {
//					userService.logInWithCache();
//				}
//			}
//		});
    }

//	@CallSuper
//	@Override
//	protected void onResume() {
//		super.onResume();
//		checkAppVersion();
//	}
//
//	protected void checkAppVersion() {
//		Logger.debug("checkAppVersion() called");
//		if (configPreferences.getRequiredVersion() > BuildConfig.VERSION_CODE) {
//			showRequiredUpdateDialog();
//		} else if (configPreferences.getCurrentVersion() > BuildConfig.VERSION_CODE && configPreferences.allowToShowUpdateDialog()) {
//			showOptionalUpdateDialog();
//		}
//	}
//
//	@CallSuper
//	@Override
//	protected void onPause() {
//		super.onPause();
//		if (updateDialog != null) {
//			updateDialog.dismiss();
//		}
//	}

//	private void showOptionalUpdateDialog() {
//		if (updateDialog != null) {
//			updateDialog.dismiss();
//		}
//		updateDialog = new AlertDialog.Builder(this)
//				.setCancelable(true)
//				.setTitle(R.string.all_update)
//				.setMessage(R.string.all_update_description)
//				.setNeutralButton(R.string.all_later, (dialog, which) -> configPreferences.rememberUpdateDialogShow())
//				.setNegativeButton(R.string.all_ignore, (dialog, which) -> configPreferences.ignoreCurrentVersionUpdateDialog())
//				.setPositiveButton(R.string.all_install, (dialog, which) -> NavigationController.openGooglePlay(this))
//				.show();
//	}
//
//	private void showRequiredUpdateDialog() {
//		if (updateDialog != null) {
//			updateDialog.dismiss();
//		}
//		updateDialog = new AlertDialog.Builder(this)
//				.setCancelable(false)
//				.setTitle(R.string.all_required_update)
//				.setMessage(R.string.all_required_update_description)
//				.setPositiveButton(R.string.all_install, (dialog, which) -> NavigationController.openGooglePlay(this))
//				.show();
//	}
//
//	private void openLogInActivity() {
//		startActivity(new Intent(this, AuthActivity.class));
//		finishAffinity();
//	}

}
