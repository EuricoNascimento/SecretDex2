package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class HeldItemDTO(
    @SerializedName("item")
    val item: DefaultNameDTO,
    @SerializedName("version_details")
    val versionDetails: List<VersionDetailDTO>?
)