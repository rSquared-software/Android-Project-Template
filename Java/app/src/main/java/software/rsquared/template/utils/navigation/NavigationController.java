package software.rsquared.template.utils.navigation;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;


public interface NavigationController {

    static void openGooglePlay(Context context) {
        final String packageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e1) {
            try {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)));
            } catch (ActivityNotFoundException e2) {
//                Toast.makeText(context, R.string.all_intent_app_not_found, Toast.LENGTH_SHORT).show();
            }
        }
    }

    boolean goBack();

    void cleanup();
}