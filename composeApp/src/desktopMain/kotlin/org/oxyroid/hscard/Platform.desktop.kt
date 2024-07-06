package org.oxyroid.hscard

import androidx.room.Room
import androidx.room.RoomDatabase
import org.oxyroid.hscard.database.HsDatabase
import java.io.File

actual class Platform {
    actual fun hsDatabaseBuilder(): RoomDatabase.Builder<HsDatabase> {
        val file = File(System.getProperty("java.io.tmpdir"), "room.db")
        return Room.databaseBuilder(
            name = file.absolutePath
        )
    }

    actual companion object {
        actual val INSTANCE: Platform by lazy {
            Platform()
        }
    }
}
