package com.alex44.companiestestapp.presenters

import com.alex44.companiestestapp.common.navigation.Screens
import com.alex44.companiestestapp.model.dto.CompanyShortDTO
import com.alex44.companiestestapp.model.repo.IDataRepo
import com.alex44.companiestestapp.views.HomeRVItemView
import com.alex44.companiestestapp.views.HomeView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class HomePresenter(private val mainThreadScheduler : Scheduler) : MvpPresenter<HomeView>() {

    @Inject
    lateinit var repo : IDataRepo

    @Inject
    lateinit var router: Router

    var rvPosition = 0

    var disposable : Disposable? = null

    var data = ArrayList<CompanyShortDTO>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        init()
    }

    private fun init() {
        viewState.initRV()
        getCompaniesData()
    }

    private fun getCompaniesData() {
        disposable = repo.getAllCompanies()
            .observeOn(mainThreadScheduler)
            .subscribe({ list ->
                data.clear()
                data.addAll(list)
                viewState.updateRV()
            }, { t ->
                t?.message?.let {
                    viewState.showMessage(it)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.let {
            if (!it.isDisposed) it.dispose()
        }
    }

    fun bind(dataHolder: HomeRVItemView) {
        val dto = data[dataHolder.getItemPosition()]
        dataHolder.setCompanyName(dto.name.orEmpty())
        dataHolder.setCompanyImage(dto.imageUrl.orEmpty())
    }

    fun clicked(position: Int) {
        val dto = data[position]
        dto.id?.let {
            router.navigateTo(Screens.DetailScreen(it))
        }
    }

}