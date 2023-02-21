package com.staygrateful.mbkmsample

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.staygrateful.mbkmsample.databinding.ActivityRawAssetsBinding
import java.io.InputStream


class RawAssetsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRawAssetsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRawAssetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadImageAssets()
        loadImageRaw()
        loadImageGlide()
    }

    private fun loadImageAssets() {
        // load image
        try {
            // get input stream
            val ims: InputStream = assets.open("pexels_photo_assets.jpeg")
            // load image as Drawable
            val d = Drawable.createFromStream(ims, null)
            // set image to ImageView
            binding.imageAssets.setImageDrawable(d)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun loadImageRaw() {
        // load image
        try {
            val ims = this.resources.openRawResource(R.raw.pexels_photo)
            val bitmap = BitmapFactory.decodeStream(ims)
            binding.imageRaw.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun loadImageGlide() {
        Glide.with(this)
            .load("https://picsum.photos/id/870/600/600")
            .into(binding.imageGlide)
    }
}