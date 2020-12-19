package com.example.basisscholengent.viewmodels


import androidx.lifecycle.ViewModel
import com.example.basisscholengent.repos.SchoolRepository


//we hebben api service nodig, hebben daardoor ViewModelFactory toegevoegd
class SchoolOverviewViewModel( repository: SchoolRepository) : ViewModel() {
      val scholen = repository.getScholen()


}