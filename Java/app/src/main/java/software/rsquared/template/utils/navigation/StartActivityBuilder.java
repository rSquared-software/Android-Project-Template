package software.rsquared.template.utils.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class StartActivityBuilder {

    private static StartActivityBuilder DISABLED = new StartActivityBuilder();

    private final Class<? extends Activity> activityClass;

    private final Intent intent;
    private Integer addFlags;
    private Integer setFlags;

    private StartActivityBuilder(@NonNull Class<? extends Activity> activityClass, @Nullable Intent intent) {
        this.activityClass = activityClass;
        this.intent = intent;
    }

    private StartActivityBuilder() {
        this.activityClass = null;
        this.intent = null;
    }

    public static StartActivityBuilder create(Class<? extends Activity> activityClass, Intent intent) {
        return new StartActivityBuilder(activityClass, intent);
    }

    public static StartActivityBuilder create(Class<? extends Activity> activityClass) {
        return new StartActivityBuilder(activityClass, null);
    }

    public static StartActivityBuilder disabled() {
        return DISABLED;
    }

    public StartActivityBuilder setFlags(int flags) {
        this.setFlags = flags;
        return this;
    }

    public StartActivityBuilder addFlags(int flags) {
        this.addFlags = flags;
        return this;
    }

    public void start(Fragment fragment) {
        final Intent intent = createIntent(fragment.getContext());
        if (intent != null) {
            fragment.startActivity(intent);
        }
    }

    public void start(Activity activity) {
        final Intent intent = createIntent(activity);
        if (intent != null) {
            activity.startActivity(intent);
        }
    }

    public void start(Fragment fragment, int requestCode) {
        final Intent intent = createIntent(fragment.getContext());
        if (intent != null) {
            fragment.startActivityForResult(intent, requestCode);
        }
    }

    public void start(Activity activity, int requestCode) {
        final Intent intent = createIntent(activity);
        if (intent != null) {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    @Nullable
    private Intent createIntent(Context context) {
        if (this.activityClass != null) {
            Intent intent = new Intent(context, this.activityClass);
            if (setFlags != null) {
                intent.setFlags(setFlags);
            }
            if (addFlags != null) {
                intent.addFlags(addFlags);
            }
            if (this.intent != null) {
                intent.putExtras(this.intent);
            }
            return intent;
        } else {
            return null;
        }
    }
}