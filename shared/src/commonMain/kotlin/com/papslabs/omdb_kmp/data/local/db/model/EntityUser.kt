package com.papslabs.omdb_kmp.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.papslabs.omdb_kmp.domain.model.User

@Entity(tableName = "user_table")
data class EntityUser(

    @PrimaryKey(autoGenerate = false)
    val id: String,

    @ColumnInfo(name = "first_name")
    val firstName: String,

    @ColumnInfo(name = "last_name")
    val lastName: String,

    val email: String
)

fun EntityUser.parse(): User = User(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email
)