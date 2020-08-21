package com.example.android.workdayassign.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.workdayassign.network.GifphyProperty
import com.example.android.workdayassign.network.GiphyApi
import com.example.android.workdayassign.network.GiphyApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel(){

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init{
        getSearchResponse()
    }
    private fun getSearchResponse(){
        GiphyApiService.retrofitSerive.getGiphyProperties().enqueue(object: Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "failure " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }

        })
    }
}