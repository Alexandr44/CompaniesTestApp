package com.alex44.companiestestapp.model.api

import com.alex44.companiestestapp.model.dto.CompanyDTO
import com.alex44.companiestestapp.model.dto.CompanyShortDTO
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {

    @GET("test.php ")
    fun getAllCompanies() : Maybe<MutableList<CompanyShortDTO>>

    @GET("test.php ")
    fun getCompany(@Query("id") query : Int) : Maybe<CompanyDTO>

}