package com.example.basisscholengent.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basisscholengent.databinding.ListItemScholenBinding
import com.example.basisscholengent.models.School

class SchoolAdapter(private var schoolClickListener: SchoolClickListener) : ListAdapter<School, SchoolViewHolder>(
        SchoolDiffCallback()
) {
    //nieuwe object SchoolViewHolder terug geven
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        return SchoolViewHolder(
                ListItemScholenBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val school = getItem(position)
        holder.bindData(school) //haal object op
        //zet de listener
        holder.itemView.setOnClickListener {
            schoolClickListener.onSchoolClicked(school)
        }
    }

}

//bij vernieuwing, wijziging -> kijken minimaal aantal updates nodig voor nieuwe lijst
private class SchoolDiffCallback : DiffUtil.ItemCallback<School>() {
    //kijken of 2 items hetzelfde zijn
    //id vergelijken
    override fun areItemsTheSame(oldItem: School, newItem: School): Boolean {
        return oldItem.recordid == newItem.recordid
    }

    //kijken of inhoud hetzelfde is
    override fun areContentsTheSame(oldItem: School, newItem: School): Boolean {
        //volledig
        return oldItem == newItem
        //enkel telefoon
        //return oldItem.fields.telefoon == newItem.fields.telefoon
    }

}

class SchoolViewHolder(val binding: ListItemScholenBinding) :
        RecyclerView.ViewHolder(binding.root) {
    fun bindData(school: School) {
        binding.school = school
    }

}

//wordt geimplementeerd in overviewFragment
interface SchoolClickListener{
    fun onSchoolClicked(school: School)

}