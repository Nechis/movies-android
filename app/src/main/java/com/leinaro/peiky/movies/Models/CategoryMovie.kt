package com.leinaro.peiky.movies.Models

import androidx.room.Entity
import androidx.room.ForeignKey
import com.leinaro.peiky.movies.Models.Category
import com.leinaro.peiky.movies.Models.Movie


    @Entity(
        tableName = "category_movie_table",
        primaryKeys = ["category_id", "movie_id"], foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["category_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Movie::class,
            parentColumns = ["id"],
            childColumns = ["movie_id"],
            onDelete = ForeignKey.CASCADE
        )]
    )
    data class CategoryMovie(
        var position: Int,
        var category_id: Int = 0,
        var movie_id:Int = 0
    )
