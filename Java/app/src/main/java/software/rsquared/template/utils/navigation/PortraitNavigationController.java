package software.rsquared.template.utils.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import software.rsquared.template.R;


public abstract class PortraitNavigationController extends BaseNavigationController {

    protected final int containerId;

    public PortraitNavigationController(AppCompatActivity activity) {
        super(activity);
        this.containerId = R.id.fragment_container;
    }

    @Override
    public void cleanup() {
    }

    protected void openFragment(FragmentFactory factory) {
        openFragment(factory, f -> true, f -> true);
    }

    protected void openFragment(FragmentFactory factory, ArgumentsFiller filler) {
        if (!activity.isDestroyed()) {
            final Fragment fragment = factory.getFragment();
            if (filler != null) {
                Bundle args = new Bundle();
                filler.putExtras(args);
                fragment.setArguments(args);
            }
            open(fragment);
        }
    }

    protected void openFragment(FragmentFactory factory, ArgumentsFiller filler, ReplacePolicy replacePolicy, BackStackPolicy backStackPolicy) {
        if (!activity.isDestroyed()) {
            final Fragment fragment = factory.getFragment();
            if (filler != null) {
                Bundle args = new Bundle();
                filler.putExtras(args);
                fragment.setArguments(args);
            }
            open(fragment, replacePolicy, backStackPolicy);
        }
    }

    protected void openFragment(FragmentFactory factory, ReplacePolicy replacePolicy, BackStackPolicy backStackPolicy) {
        if (!activity.isDestroyed()) {
            final Fragment fragment = factory.getFragment();

            open(fragment, replacePolicy, backStackPolicy);
        }
    }

    protected void open(Fragment fragment) {
        open(fragment, frag -> true, fr -> false);
    }

    protected void open(Fragment fragment, ReplacePolicy replacePolicy, BackStackPolicy backStackPolicy) {
        open(containerId, fragment, replacePolicy, backStackPolicy);
    }
}