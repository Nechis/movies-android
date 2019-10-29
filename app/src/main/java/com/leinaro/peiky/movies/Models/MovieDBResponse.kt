package com.leinaro.peiky.movies.Models

data class MovieDBResponse (
    var page: Int,
    var total_results: Int,
    var results: List<Movie>
)