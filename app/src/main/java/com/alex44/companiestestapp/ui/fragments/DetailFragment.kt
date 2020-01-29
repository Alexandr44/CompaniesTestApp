package com.alex44.companiestestapp.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.alex44.companiestestapp.App
import com.alex44.companiestestapp.R
import com.alex44.companiestestapp.common.interfaces.BackButtonListener
import com.alex44.companiestestapp.common.interfaces.IImageLoader
import com.alex44.companiestestapp.presenters.DetailPresenter
import com.alex44.companiestestapp.views.DetailView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject
import javax.inject.Named

class DetailFragment : MvpAppCompatFragment(), DetailView, BackButtonListener {

    @InjectPresenter
    lateinit var presenter: DetailPresenter

    @field: [Inject Named("Glide")]
    lateinit var imageLoader : IImageLoader<ImageView>

    companion object {
        fun newInstance(id : Int) : DetailFragment {
            val arguments = Bundle()
            arguments.putInt("id", id)
            val fragment = DetailFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.instance.appComponent.inject(this)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    @ProvidePresenter
    fun createPresenter() : DetailPresenter {
        val id = arguments?.getInt("id")
        val presenter = DetailPresenter(id?:0, AndroidSchedulers.mainThread())
        App.instance.appComponent.inject(presenter)
        return presenter
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun backClick(): Boolean {
        return presenter.backClicked()
    }

    override fun setName(name: String) {
        detail_name.text = name
    }

    override fun setImage(photoUrl: String) {
        imageLoader.loadIntoFromAssets(photoUrl, detail_image, 40)
    }

    override fun setDescription(description: String) {
        detail_description.text = description
    }

    override fun setLatitude(latitude: Double) {
        val text = "lat:$latitude"
        detail_latitude.text = text
    }

    override fun setLongitude(longitude: Double) {
        val text = "long:$longitude"
        detail_longitude.text = text
    }

    override fun setSite(site: String) {
        detail_site.text = site
    }

    override fun setPhone(phone: String) {
        detail_phone.text = phone
    }

}
