package software.rsquared.template.ui.loading

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import software.rsquared.template.di.annotation.ViewModelKey

/**
 * @author Rafal Orlik
 */
@Module
interface LoadingModule {

	@Binds
	@IntoMap
	@ViewModelKey(LoadingViewModel::class)
	fun bindLoadingViewModel(viewModel: LoadingViewModel): ViewModel

}