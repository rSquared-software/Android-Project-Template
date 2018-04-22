package software.rsquared.template.di;

import dagger.Module;
import dagger.Provides;
import software.rsquared.template.ui.main.MainActivity;
import software.rsquared.template.ui.main.MainNavigationController;
import software.rsquared.template.ui.main.MainPortraitNavigationController;

/**
 * @author rSquared.software
 */
@Module
class MainActivityModule {

	@Provides
    MainNavigationController provideMainNavigationController(MainActivity activity) {
//		boolean land = activity.getResources().getBoolean(R.bool.land);
//		if (land){
//			return new MainLandNavigationController(activity);
//		}else{
//			return new MainPortraitNavigationController(activity);
//		}
        return new MainPortraitNavigationController(activity);
    }
}
