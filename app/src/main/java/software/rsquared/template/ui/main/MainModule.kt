package software.rsquared.template.ui.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import software.rsquared.template.di.annotation.FragmentScoped
import software.rsquared.template.di.annotation.ViewModelKey
import software.rsquared.template.ui.loading.LoadingFragment
import software.rsquared.template.ui.loading.LoadingModule

@Module
interface MainModule {

//	As long as you don't provides anything you can have your module as an interface

	@FragmentScoped
	@ContributesAndroidInjector(modules = [LoadingModule::class])
	fun contributeLogInFragment(): LoadingFragment

	@FragmentScoped
	@ContributesAndroidInjector
	fun contributeSettingsSheetDialog(): SettingsSheetDialog

	@Binds
	@IntoMap
	@ViewModelKey(MainViewModel::class)
	fun bindReportViewModel(reportViewModel: MainViewModel): ViewModel


}