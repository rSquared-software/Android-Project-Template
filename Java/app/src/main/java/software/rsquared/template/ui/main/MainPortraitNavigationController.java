package software.rsquared.template.ui.main;

import android.support.v7.app.AppCompatActivity;

import software.rsquared.template.utils.navigation.PortraitNavigationController;
import software.rsquared.template.utils.navigation.StartActivityBuilder;

public class MainPortraitNavigationController extends PortraitNavigationController implements MainNavigationController{


    public MainPortraitNavigationController(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public boolean goBack() {
        return false;
    }

    @Override
    public StartActivityBuilder navigateToSimpleExample() {
        return null;
    }
}
