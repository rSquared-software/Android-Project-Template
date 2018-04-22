package software.rsquared.template.utils.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import software.rsquared.template.R;


public abstract class LandNavigationController extends BaseNavigationController {

    protected final int mainContainerId;
    protected final int secondaryContainerId;

    public LandNavigationController(AppCompatActivity activity) {
        super(activity);
        this.mainContainerId = R.id.fragment_container;
        this.secondaryContainerId = R.id.fragment_container;
    }

    protected synchronized void showSecondaryFragment(boolean show) {
        View view = activity.findViewById(secondaryContainerId);
        if (view != null) {
            int visibility = show ? View.VISIBLE : View.GONE;
            if (view.getVisibility() != visibility) {
                view.setVisibility(visibility);
            }
        }
    }

    @Override
    public void cleanup() {
        Fragment fragment = fragmentManager.findFragmentById(secondaryContainerId);
        if (fragment != null) {
            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }

    protected void openFragment(FragmentFactory factory) {
        openFragment(factory, f -> true, f -> true);
    }

    protected void openSecondaryFragment(FragmentFactory factory) {
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

    protected void openSecondaryFragment(FragmentFactory factory, ArgumentsFiller filler) {
        if (!activity.isDestroyed()) {
            final Fragment fragment = factory.getFragment();
            if (filler != null) {
                Bundle args = new Bundle();
                filler.putExtras(args);
                fragment.setArguments(args);
            }
            openSecondary(fragment);
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

    protected void openSecondaryFragment(FragmentFactory factory, ArgumentsFiller filler, ReplacePolicy replacePolicy, BackStackPolicy backStackPolicy) {
        if (!activity.isDestroyed()) {
            final Fragment fragment = factory.getFragment();
            if (filler != null) {
                Bundle args = new Bundle();
                filler.putExtras(args);
                fragment.setArguments(args);
            }
            openSecondary(fragment, replacePolicy, backStackPolicy);
        }
    }

    protected void openFragment(FragmentFactory factory, ReplacePolicy replacePolicy, BackStackPolicy backStackPolicy) {
        if (!activity.isDestroyed()) {
            final Fragment fragment = factory.getFragment();

            open(fragment, replacePolicy, backStackPolicy);
        }
    }

    protected void openSecondaryFragment(FragmentFactory factory, ReplacePolicy replacePolicy, BackStackPolicy backStackPolicy) {
        if (!activity.isDestroyed()) {
            final Fragment fragment = factory.getFragment();

            openSecondary(fragment, replacePolicy, backStackPolicy);
        }
    }

    protected void open(Fragment fragment) {
        open(fragment, frag -> true, fr -> false);
    }

    protected void open(Fragment fragment, ReplacePolicy replacePolicy, BackStackPolicy backStackPolicy) {
        open(mainContainerId, fragment, replacePolicy, backStackPolicy);
    }

    protected void openSecondary(Fragment fragment) {
        openSecondary(fragment, frag -> true, fr -> false);
    }

    protected void openSecondary(Fragment fragment, ReplacePolicy replacePolicy, BackStackPolicy backStackPolicy) {
        open(secondaryContainerId, fragment, replacePolicy, backStackPolicy);
    }

}