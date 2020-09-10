package com.nurram.animelist.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurram.animelist.data.model.Animes
import com.nurram.animelist.utils.Resources
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repo: MainRepo): ViewModel() {

    private val _animes = MutableLiveData<Resources<Animes>>()
    val animes: LiveData<Resources<Animes>>
    get() = _animes

    fun getTopAnimes() {
        _animes.postValue(Resources.onLoading())

        repo.getTopAnimes().enqueue(object: Callback<Animes> {
            override fun onResponse(call: Call<Animes>, response: Response<Animes>) =
                _animes.postValue(Resources.onSuccess(response.body()))

            override fun onFailure(call: Call<Animes>, t: Throwable) =
                _animes.postValue(Resources.onError(t.message))
        })
    }
}