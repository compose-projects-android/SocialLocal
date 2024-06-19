/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.compose_projects.socialLocal.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.compose_projects.socialLocal.core.database.daos.Chat
import org.compose_projects.socialLocal.core.database.daos.ChatDao
import org.compose_projects.socialLocal.core.database.daos.DataChat
import org.compose_projects.socialLocal.core.database.daos.DataChatDao
import org.compose_projects.socialLocal.core.database.daos.Multimedia
import org.compose_projects.socialLocal.core.database.daos.MultimediaDao
import org.compose_projects.socialLocal.core.database.daos.Profile
import org.compose_projects.socialLocal.core.database.daos.ProfileDao
import org.compose_projects.socialLocal.core.database.daos.User
import org.compose_projects.socialLocal.core.database.daos.UserDao

@Database(
    entities = [
        User::class,
        Multimedia::class,
        DataChat::class,
        Profile::class,
        Chat::class],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun multimediaDao(): MultimediaDao
    abstract fun dataChatDao(): DataChatDao
    abstract fun profileDao(): ProfileDao
    abstract fun chatDao(): ChatDao
}
