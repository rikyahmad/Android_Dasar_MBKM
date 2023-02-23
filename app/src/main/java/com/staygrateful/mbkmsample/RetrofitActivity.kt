package com.staygrateful.mbkmsample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.staygrateful.mbkmsample.databinding.ActivityRetrofitBinding
import com.staygrateful.mbkmsample.retrofit.NetworkModule
import com.staygrateful.mbkmsample.retrofit.model.ResultMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRetrofitBinding
    private val log = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NetworkModule.loggerCallback = {
            lifecycleScope.launch(Dispatchers.Main) {
                log.append("$it\n")
                binding.response.text = log.toString()
            }
        }

        getMovieList()
    }

    /*private fun loadImage() {
        Glide.with(this)
            .load("https://picsum.photos/seed/picsum/800/800")
            .into(binding.image)
    }*/

    private fun getMovieList() {
        val service = NetworkModule.Builder()
        val getMovieListApi = service.getMovieList()

        getMovieListApi?.enqueue(object : Callback<ResultMovie?> {
            override fun onResponse(call: Call<ResultMovie?>, response: Response<ResultMovie?>) {
                val movieList = response.body()
                if (movieList != null) {
                    val result = movieList.results
                }
                Log.d("getMovieList", response.raw().body.toString())
            }

            override fun onFailure(call: Call<ResultMovie?>, t: Throwable) {
                showMessage("Cannot get movie list : ${t.localizedMessage}")
                Log.e("getMovieList", t.localizedMessage)
            }
        })
    }

    private fun showMessage(msg: String) {
        Toast.makeText(
            this@RetrofitActivity, msg, Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        const val BASE_URL = "https://api.themoviedb.org"
    }
}