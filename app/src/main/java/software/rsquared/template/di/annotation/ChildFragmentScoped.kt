package software.rsquared.template.di.annotation


import javax.inject.Scope

/**
 * The ChildFragmentScoped custom scoping annotation specifies that the lifespan of a dependency be
 * the same as that of a child Fragment. This is used to annotate dependencies that behave like a
 * singleton within the lifespan of a child Fragment
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class ChildFragmentScoped
