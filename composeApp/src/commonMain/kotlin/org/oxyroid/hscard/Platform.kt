package org.oxyroid.hscard

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.oxyroid.hscard.database.HsDatabase

val platform by lazy { Platform.INSTANCE }
val database by lazy {
    platform
        .hsDatabaseBuilder()
        .setDriver(BundledSQLiteDriver())
        .build()
}

expect class Platform {
    fun hsDatabaseBuilder(): RoomDatabase.Builder<HsDatabase>

    companion object {
        val INSTANCE: Platform
    }
}
