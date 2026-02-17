package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class GameIndexDTO(
    @SerializedName("game_index")
    val gameIndex: Int?,
    @SerializedName("version")
    val version: DefaultNameDTO
)