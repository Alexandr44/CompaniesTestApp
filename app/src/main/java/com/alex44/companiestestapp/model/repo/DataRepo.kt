package com.alex44.companiestestapp.model.repo

import com.alex44.companiestestapp.common.interfaces.INetworkStatus
import com.alex44.companiestestapp.model.api.IDataSource
import com.alex44.companiestestapp.model.dto.CompanyDTO
import com.alex44.companiestestapp.model.dto.CompanyShortDTO
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import io.reactivex.schedulers.Schedulers

class DataRepo(private var source: IDataSource, private val networkStatus: INetworkStatus) : IDataRepo {

    override fun getAllCompanies(): Maybe<MutableList<CompanyShortDTO>> {
        if (networkStatus.isOnline()) {
            return source.getAllCompanies()
                .subscribeOn(Schedulers.io())
                .map { list ->
                    list.retainAll {
                        return@retainAll it.id != null && !it.name.isNullOrBlank()
                    }
                    return@map list
                }
        }
        else {
            return Maybe.create { emitter: MaybeEmitter<MutableList<CompanyShortDTO>> ->
                emitter.onError(RuntimeException("No internet"))
            }
                .subscribeOn(Schedulers.io())
        }
    }

    override fun getCompany(id: Int): Maybe<CompanyDTO> {
        if (networkStatus.isOnline()) {
            return source.getCompany(id)
                .subscribeOn(Schedulers.io())
                .filter {list ->
                    list.retainAll {
                        return@retainAll it.id != null && !it.name.isNullOrBlank()
                    }
                    return@filter true
                }
                .map {list ->
                    if (list.size == 1) {
                        return@map list[0]
                    }
                    else throw RuntimeException("Bad Answer")
                }
        }
        else {
            return Maybe.create { emitter: MaybeEmitter<CompanyDTO> ->
                emitter.onError(RuntimeException("No internet"))
            }
                .subscribeOn(Schedulers.io())
        }
    }

}