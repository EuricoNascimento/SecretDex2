package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class OtherDTO(
    @SerializedName("home")
    val home: HomeDTO?,
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtworkDTO?
)