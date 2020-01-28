package com.alex44.companiestestapp.model.repo

import com.alex44.companiestestapp.model.dto.CompanyDTO
import com.alex44.companiestestapp.model.dto.CompanyShortDTO
import io.reactivex.Maybe

interface IDataRepo {

    fun getAllCompanies() : Maybe<MutableList<CompanyShortDTO>>

    fun getCompany(id : Int) : Maybe<CompanyDTO>

}