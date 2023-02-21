package com.staygrateful.mbkmsample.retrofit.model

data class ResultMovie(
    var dates: Dates? = Dates(),
    var page: Int? = null,
    var results: List<Results> = arrayListOf(),
    var total_pages: Int? = null,
    var total_results: Int? = null
)

data class Dates(
    var maximum: String? = null,
    var minimum: String? = null
)

data class Results(
    var adult: Boolean? = null,
    var backdrop_path: String? = null,
    var genre_ids: List<Int> = arrayListOf(),
    var id: Int? = null,
    var original_language: String? = null,
    var original_title: String? = null,     //title
    var overview: String? = null,           //desc
    var popularity: Double? = null,
    var poster_path: String? = null,        //url image
    var release_date: String? = null,
    var title: String? = null,
    var video: Boolean? = null,
    var vote_average: Double? = null,
    var vote_count: Int? = null
)