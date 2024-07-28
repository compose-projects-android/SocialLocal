package org.compose_projects.socialLocal.feature.multimedia.directoryManager

import android.content.Context
import android.os.Environment
import java.io.File

private fun tree(dir: File, indent: String = ""): String  {
    val treeBuilder = StringBuilder()

    if (dir.exists() && dir.isDirectory) {
        treeBuilder.append("$indent${dir.name}\n")
        val subDirs = dir.listFiles { file -> file.isDirectory }?.sorted() ?: emptyList()

        for (subDir in subDirs) {
            treeBuilder.append(tree(subDir, "$indent    "))
        }
    }
    return treeBuilder.toString()
}

internal fun listAppDirectories(context: Context, appName: String): String {
    val baseDir = File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
        appName
    )
    return tree(baseDir)
}