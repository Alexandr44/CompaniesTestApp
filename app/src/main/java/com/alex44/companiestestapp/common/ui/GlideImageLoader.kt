package com.alex44.companiestestapp.common.ui

import android.net.Uri
import android.widget.ImageView
import com.alex44.companiestestapp.common.interfaces.IImageLoader
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class GlideImageLoader : IImageLoader<ImageView> {

    override fun loadInto(url: String, container: ImageView, corners: Int) {
        val multi = MultiTransformation(RoundedCorners(corners))
        Glide.with(container.context)
            .load(url)
            .apply(RequestOptions.bitmapTransform(multi))
            .into(container)
    }

    override fun loadIntoFromAssets(url: String, container: ImageView, corners: Int) {
        val multi = MultiTransformation(RoundedCorners(corners))
        Glide.with(container.context)
            .load(Uri.parse("file:///android_asset/$url"))
            .apply(RequestOptions.bitmapTransform(multi))
            .into(container)
    }

}