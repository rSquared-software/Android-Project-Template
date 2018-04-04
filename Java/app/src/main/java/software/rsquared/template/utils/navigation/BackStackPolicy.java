package software.rsquared.template.utils.navigation;

import android.support.v4.app.Fragment;

/**
 * @author Rafał Zajfert
 */
public interface BackStackPolicy {

    boolean addToBackStack(Fragment fragment);

}
