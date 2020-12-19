package com.example.basisscholengent.viewmodels


import androidx.lifecycle.ViewModel
import com.example.basisscholengent.repos.SchoolRepository


//we hebben api service nodig, hebben daardoor ViewModelFactory toegevoegd
class SchoolOverviewViewModel( repository: SchoolRepository) : ViewModel() {
      val scholen = repository.getScholen()



/*    private var     _scholen = MutableLiveData<List<School>>()
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
    }*/

}