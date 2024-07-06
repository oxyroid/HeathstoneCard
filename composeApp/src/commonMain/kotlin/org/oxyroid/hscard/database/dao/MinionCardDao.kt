package org.oxyroid.hscard.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.oxyroid.hscard.database.model.MinionCard

@Dao
interface MinionCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg card: MinionCard): List<Long>

    @Delete
    suspend fun delete(vararg card: MinionCard)

    @Query("SELECT * FROM minion_cards WHERE id = :id")
    suspend fun get(id: Long): MinionCard?

    @Query("SELECT * FROM minion_cards WHERE id = :id")
    fun observe(id: Long): Flow<MinionCard?>

    @Query("SELECT * FROM minion_cards")
    suspend fun getAll(): List<MinionCard>

    @Query("SELECT * FROM minion_cards")
    fun observeAll(): Flow<List<MinionCard>>
}
