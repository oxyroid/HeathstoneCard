package org.oxyroid.hscard

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.oxyroid.hscard.database.HsDatabase

actual class Platform(
    private val applicationContext: Context
) {
    actual fun hsDatabaseBuilder(): RoomDatabase.Builder<HsDatabase> {
        val file = applicationContext.getDatabasePath("room.db")
        return Room.databaseBuilder(
            context = applicationContext,
            name = file.absolutePath
        )
    }

    actual companion object {
        actual val INSTANCE: Platform by lazy {
            Platform(
                applicationContext = applicationContext
            )
        }
    }
}
