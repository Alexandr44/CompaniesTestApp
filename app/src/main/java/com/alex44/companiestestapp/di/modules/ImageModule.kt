package com.alex44.companiestestapp.di.modules

import android.widget.ImageView
import com.alex44.companiestestapp.common.interfaces.IImageLoader
import com.alex44.companiestestapp.common.ui.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ImageModule {

    @Named("Glide")
    @Provides
    fun glideImageLoader() : IImageLoader<ImageView> = GlideImageLoader()

}