package com.alex44.companiestestapp.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CompanyDTO (
    @Expose @SerializedName("id") val id : Int? = null,
    @Expose @SerializedName("name") val name : String? = null,
    @Expose @SerializedName("img") val imageUrl : String? = null,
    @Expose @SerializedName("description") val description : String? = null,
    @Expose @SerializedName("lat") val latitude : Double? = null,
    @Expose @SerializedName("lon") val longitude : Double? = null,
    @Expose @SerializedName("www") val site : String? = null,
    @Expose @SerializedName("phone") val phone : String? = null
) : Serializable