package com.opensource.armnews.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.opensource.armnews.data.model.APIResponse
import com.opensource.armnews.data.util.Resource
import com.opensource.armnews.domain.usecase.GetNewsHeadlinesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val application: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
) : AndroidViewModel(application) {

    val newsHeadLines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.Loading())

        try {
            when (isNetworkAvailable(application)) {
                true -> {
                    val apiResult = getNewsHeadlinesUseCase.execute(country, page)
                    newsHeadLines.postValue(apiResult)
                }

                false -> {
                    newsHeadLines.postValue(Resource.Error("Internet is not available"))
                }
            }
        } catch (e: Exception) {
            Log.e("NewsViewModel", "Error: ${e.message}")
        }
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        // Todo: Add ConnectivityManager code here. Also check for relevant permissions
        return true
    }
}