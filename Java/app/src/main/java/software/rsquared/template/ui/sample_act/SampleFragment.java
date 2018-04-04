package software.rsquared.template.ui.sample_act;

import android.os.Bundle;
import android.support.annotation.Nullable;

import software.rsquared.template.R;
import software.rsquared.template.databinding.FragmentSampleBinding;
import software.rsquared.template.ui.BaseFragment;

public class SampleFragment extends BaseFragment<SampleViewModel, FragmentSampleBinding> {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_sample;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //from here on viewModel is available and injected


    }
}
