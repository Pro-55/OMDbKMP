package com.papslabs.omdb_kmp.util

import androidx.room.TypeConverter
import com.papslabs.omdb_kmp.domain.model.Type

class RoomTypeConverter {

    @TypeConverter
    fun toContentType(value: Int?): Type {
        return Type.entries[value ?: 0]
    }

    @TypeConverter
    fun fromContentType(contentType: Type?): Int {
        return contentType?.ordinal ?: 0
    }

}