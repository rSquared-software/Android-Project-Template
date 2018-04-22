package software.rsquared.template.ui.main;

import android.os.Bundle;

import software.rsquared.template.R;
import software.rsquared.template.databinding.ActivityMainBinding;
import software.rsquared.template.ui.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity<ActivityMainBinding> {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.get().setCallback(new Callback() {
            @Override
            public void onShowFragment() {

            }

            @Override
            public void onShowPagerSample() {

            }
        });
    }

    public interface Callback {

        void onShowFragment();

        void onShowPagerSample();

    }
}
