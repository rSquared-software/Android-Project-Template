package software.rsquared.template.utils.navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


/**
 * @author Rafał Zajfert
 */
public abstract class BaseNavigationController implements NavigationController {

    protected final FragmentManager fragmentManager;

    protected final FragmentActivity activity;

    public BaseNavigationController(FragmentActivity activity) {
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
}
