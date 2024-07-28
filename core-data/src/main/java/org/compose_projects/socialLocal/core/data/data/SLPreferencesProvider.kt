package org.compose_projects.socialLocal.core.data.data

data class SLPreferencesProvider(
    val id: Int = 0,
    val theme: String,
    val userName: String,
    val description: String? = null,
    val pathImageProfile: String? = null
)
