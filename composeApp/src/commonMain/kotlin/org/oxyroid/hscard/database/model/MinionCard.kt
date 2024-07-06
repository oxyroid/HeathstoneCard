package org.oxyroid.hscard.database.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "minion_cards")
data class MinionCard(
    @ColumnInfo("cost")
    val cost: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("attack")
    val attack: Int,
    @ColumnInfo("defense")
    val defense: Int,
    @ColumnInfo("race")
    val race: Race,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("image")
    val image: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Long = 0
) {
    @Keep
    enum class Race {
        Beast,
        Demon,
        Dragon,
        Mech,
        Murloc,
        Pirate,
        Totem,
        Elemental,
        None
    }
}
