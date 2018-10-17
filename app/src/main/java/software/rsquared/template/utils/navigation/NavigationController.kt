package software.rsquared.template.utils.navigation

interface NavigationController {

    fun goBack(): Boolean

    fun cleanup() {}
}