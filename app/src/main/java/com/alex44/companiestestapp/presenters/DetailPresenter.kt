package com.alex44.companiestestapp.presenters

import com.alex44.companiestestapp.common.navigation.Screens
import com.alex44.companiestestapp.model.dto.CompanyDTO
import com.alex44.companiestestapp.model.repo.IDataRepo
import com.alex44.companiestestapp.views.DetailView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class DetailPresenter(private val id: Int, private val mainThreadScheduler : Scheduler) : MvpPresenter<DetailView>() {

    @Inject
    lateinit var repo : IDataRepo

    @Inject
    lateinit var router: Router

    var disposable : Disposable? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCompanyData(id)
    }

    private fun loadCompanyData(id: Int) {
        disposable = repo.getCompany(id)
            .observeOn(mainThreadScheduler)
            .subscribe({ dto ->
                if (dto?.id != null) {
                    updateInfo(dto)
                }
            }, { t ->
                t?.message?.let {
                    viewState.showMessage(it)
                }
            })
    }

    private fun updateInfo(dto: CompanyDTO?) {
        viewState.setName(dto?.name.orEmpty())
        viewState.setImage(dto?.imageUrl.orEmpty())
        viewState.setDescription(dto?.description.orEmpty())
        viewState.setLatitude(dto?.latitude?:0.0)
        viewState.setLongitude(dto?.longitude?:0.0)
        viewState.setPhone(dto?.phone.orEmpty())
        viewState.setSite(dto?.site.orEmpty())
    }

    fun backClicked() : Boolean {
        router.backTo(Screens.HomeScreen())
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.let {
            if (!it.isDisposed) it.dispose()
        }
    }

}