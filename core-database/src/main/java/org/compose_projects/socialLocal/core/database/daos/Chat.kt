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

package org.compose_projects.socialLocal.core.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Entity
data class Chat(
    @PrimaryKey(autoGenerate = true)
    val chatID: Int = 0,
    val isChatGlobal: Boolean,
    val profileID: Int? = 0
)

@Dao
interface ChatDao {
    @Query("SELECT * FROM Chat")
    fun getChat(): Flow<List<Chat>>

    @Update
    fun updateChat(item: Chat)

    @Insert
    suspend fun insertChat(item: Chat)

    @Delete
    suspend fun deleteChat(item: Chat)
}