package com.example.basisscholengent.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basisscholengent.data.remote.GhentApiService
import com.example.basisscholengent.models.School
import kotlinx.coroutines.launch

//we hebben api service nodig, hebben daardoor ViewModelFactory toegevoegd
class SchoolOverviewViewModel(private val apiService: GhentApiService) : ViewModel() {
    private var _scholen = MutableLiveData<List<School>>()
    val scholen: LiveData<List<School>>
        get() = _scholen

    //wanneer SchoolOverviewViewModel geinitialiseerd
    init {
        //halen alle scholen
        //dmv viewModelScope
        getScholen()
    }

    private fun getScholen() {
        //om het in coroutine te houden
        viewModelScope.launch {
            try {
                //api service nodig
                val response = apiService.getScholen();
                //LiveData object opvullen met list<School>
                _scholen.value = response.records
            } catch (e: Exception) {
                Log.e("Error api ", e.message, e)
            }
        }
    }

}