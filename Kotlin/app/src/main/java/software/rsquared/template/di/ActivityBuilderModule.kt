package software.rsquared.template.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import software.rsquared.template.ui.main.MainActivity

/**
 * @author Rafal Orlik
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainModule::class, MainFragmentsBuilder::class])
    internal abstract fun contributeMainActivity(): MainActivity
}