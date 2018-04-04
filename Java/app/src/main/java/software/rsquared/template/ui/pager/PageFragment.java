package software.rsquared.template.ui.pager;

import software.rsquared.template.R;
import software.rsquared.template.ui.BaseFragment;

public class PageFragment extends BaseFragment {

    @Override
    protected boolean useActivityViewModel() {
        return true;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_page;
    }

}
