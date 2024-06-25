package org.compose_projects.socialLocal.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.compose_projects.socialLocal.core.data.data.SLPreferencesProvider
import org.compose_projects.socialLocal.core.database.daos.SLPreferences
import org.compose_projects.socialLocal.core.database.daos.SLPreferencesDao
import javax.inject.Inject

interface SLPreferencesRepository {
    val preferences: Flow<List<SLPreferencesProvider>>
    suspend fun insert(slPreferencesProvider: SLPreferencesProvider)

    suspend fun update(slPreferencesProvider: SLPreferencesProvider)

    suspend fun delete(slPreferencesProvider: SLPreferencesProvider)
}


class SLPreferencesRepositoryImp @Inject constructor(
    private val slPreferencesDao: SLPreferencesDao
) : SLPreferencesRepository {
    override val preferences: Flow<List<SLPreferencesProvider>> =
        slPreferencesDao.getSLPreferences().map { items ->
            items.map {
                SLPreferencesProvider(
                    theme = it.theme,
                    userName = it.userName,
                    description = it.description,
                    pathImageProfile = it.pathImageProfile
                )
            }

        }

    override suspend fun insert(slPreferencesProvider: SLPreferencesProvider) =
        slPreferencesDao.insertSLPreferences(
            SLPreferences(
                theme = slPreferencesProvider.theme,
                userName = slPreferencesProvider.userName,
                description = slPreferencesProvider.description,
                pathImageProfile = slPreferencesProvider.pathImageProfile
            )
        )

    override suspend fun update(slPreferencesProvider: SLPreferencesProvider) =
        slPreferencesDao.updateSLPreferences(
            SLPreferences(
                theme = slPreferencesProvider.theme,
                userName = slPreferencesProvider.userName,
                description = slPreferencesProvider.description,
                pathImageProfile = slPreferencesProvider.pathImageProfile
            )
        )

    override suspend fun delete(slPreferencesProvider: SLPreferencesProvider) =
        slPreferencesDao.deleteSLPreferences(
            SLPreferences(
                theme = slPreferencesProvider.theme,
                userName = slPreferencesProvider.userName,
                description = slPreferencesProvider.description,
                pathImageProfile = slPreferencesProvider.pathImageProfile
            )
        )

}