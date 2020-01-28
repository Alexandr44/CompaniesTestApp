package com.alex44.companiestestapp.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CompanyShortDTO (
    @Expose @SerializedName("id") val id : Int? = null,
    @Expose @SerializedName("name") val name : String? = null,
    @Expose @SerializedName("img") val imageUrl : String? = null
    ) : Serializable