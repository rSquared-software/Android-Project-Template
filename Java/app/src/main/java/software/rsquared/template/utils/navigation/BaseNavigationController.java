package software.rsquared.template.utils.navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


/**
 * @author Rafał Zajfert
 */
public abstract class BaseNavigationController implements NavigationController {

    protected final FragmentManager fragmentManager;

    protected final AppCompatActivity activity;

    public BaseNavigationController(AppCompatActivity activity) {
        this.fragmentManager = activity.getSupportFragmentManager();
        this.activity = activity;
    }

    protected void clearBackStack() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = fragmentManager.getBackStackEntryAt(0);
            try {
                fragmentManager.popBackStackImmediate(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            } catch (IllegalStateException e) {

            }
        }
    }

    protected StartActivityBuilder openActivity(Class<? extends Activity> activityClass) {
        return openActivity(activityClass, null);
    }

    protected StartActivityBuilder openActivity(Class<? extends Activity> activityClass, ExtraFiller filler) {
        Intent intent = null;
        if (filler != null) {
            intent = new Intent();
            filler.putExtras(intent);
        }
        return StartActivityBuilder.create(activityClass, intent);
    }


    protected void open(@IdRes int idRes, Fragment fragment, ReplacePolicy replacePolicy, BackStackPolicy backStackPolicy) {
        @Nullable
        Fragment fragmentById = fragmentManager.findFragmentById(idRes);
        if (fragmentById == null || replacePolicy.allowReplace(fragmentById)) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            if (backStackPolicy.addToBackStack(fragmentById)) {
                transaction.addToBackStack(null);
            }
            transaction.replace(idRes, fragment);
            transaction.setReorderingAllowed(true);
            transaction.commitAllowingStateLoss();
        }
    }
}
