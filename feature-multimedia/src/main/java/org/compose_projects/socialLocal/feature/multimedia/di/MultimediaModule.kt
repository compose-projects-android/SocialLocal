package org.compose_projects.socialLocal.feature.multimedia.di

import android.net.Uri
import android.os.Environment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.appname
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.images
import java.io.File


@Module
@InstallIn(SingletonComponent::class)
object MultimediaModule {
    @Provides
    fun providesPathImagesCG(): PathImagesCG = PathImagesCGImpl()

    @Provides
    fun provideUri(uri: Uri): Uri = uri

    @Provides
    fun provideTypeChat(type: String): String = type

}

interface PathImagesCG {
    fun PathImages(): File
}

class PathImagesCGImpl : PathImagesCG {
    override fun PathImages(): File {
        val baseDir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
            appname
        )
        val imagesDir = File(baseDir, images)
        val chatGlobalDir = File(imagesDir, chatglobal)
        return chatGlobalDir
    }
}

