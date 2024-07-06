package org.oxyroid.hscard.database

import androidx.room.TypeConverter
import org.oxyroid.hscard.database.model.MinionCard

object HsDbTypeConverters {
    @TypeConverter
    fun fromRace(race: MinionCard.Race): String = race.name

    @TypeConverter
    fun toRace(name: String): MinionCard.Race = MinionCard.Race.valueOf(name)
}
