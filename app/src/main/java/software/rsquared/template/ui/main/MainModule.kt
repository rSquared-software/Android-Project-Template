package software.rsquared.template.ui.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import software.rsquared.template.di.annotation.ViewModelKey

@Module
abstract class MainModule {

	@Binds
	@IntoMap
	@ViewModelKey(MainViewModel::class)
	abstract fun bindReportViewModel(reportViewModel: MainViewModel): ViewModel
}