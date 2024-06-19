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
data class DataChat(
    @PrimaryKey(autoGenerate = true)
    val dataChatID: Int = 0,
    val dateTime: String,
    val iSend: Boolean,
    val contentType: String,
    val multimediaID: Int
)

@Dao
interface DataChatDao {
    @Query("SELECT * FROM DataChat")
    fun getDataChat(): Flow<List<DataChat>>

    @Update
    fun updateDataChat(item: DataChat)

    @Insert
    suspend fun insertDataChat(item: DataChat)

    @Delete
    suspend fun deleteDataChat(item: DataChat)
}
