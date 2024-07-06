package org.oxyroid.hscard.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.oxyroid.hscard.database.dao.MinionCardDao
import org.oxyroid.hscard.database.model.MinionCard

@Database(
    version = 1,
    entities = [MinionCard::class],
    exportSchema = true
)
@TypeConverters(
    HsDbTypeConverters::class
)
abstract class HsDatabase : RoomDatabase() {
    abstract fun minionCardDao(): MinionCardDao
}
