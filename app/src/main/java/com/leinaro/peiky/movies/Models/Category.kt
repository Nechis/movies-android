package com.leinaro.peiky.movies.Models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "category_table")
data class Category (
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    @NonNull
    var category: String
)
