package com.rkm.moviesdemokotlin.rtllabs.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val id: Long = 0,

    @SerializedName("title")
    val title: String? = null,


    @SerializedName("poster_path")
    val posterPath: String? = null,


    @SerializedName("backdrop_path")
    val backdropPath: String? = null,


    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0,


    @SerializedName("vote_count")
    var voteCount: Int = 0,

    @SerializedName("original_language")
    val language: String? = null,


    @SerializedName("release_date")
    val releaseDate: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("popularity")
    val popularity:Double=0.0,


    val categoryType:Category = Category.POPULAR

):Parcelable{
}
