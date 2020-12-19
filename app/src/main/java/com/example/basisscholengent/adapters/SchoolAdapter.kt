package com.example.basisscholengent.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basisscholengent.data.local.SchoolEntity
import com.example.basisscholengent.databinding.ListItemScholenBinding

class SchoolAdapter(private val schoolClickListener: SchoolClickListener) : ListAdapter<SchoolEntity, SchoolViewHolder>(
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

    override fun onBindViewHolder(view: SchoolViewHolder, position: Int) {
        val school = getItem(position)
        view.bindData(school) //haal object op
        //zet de listener
        view.itemView.setOnClickListener {
            schoolClickListener.onSchoolClicked(school)
        }
    }

}

//bij vernieuwing, wijziging -> kijken minimaal aantal updates nodig voor nieuwe lijst
private class SchoolDiffCallback : DiffUtil.ItemCallback<SchoolEntity>() {
    //kijken of 2 items hetzelfde zijn
    //id vergelijken
    override fun areItemsTheSame(oldItem: SchoolEntity, newItem: SchoolEntity): Boolean {
        return oldItem.recordid == newItem.recordid
    }

    //kijken of inhoud hetzelfde is
    override fun areContentsTheSame(oldItem: SchoolEntity, newItem: SchoolEntity): Boolean {
        //volledig
        return oldItem.equals(newItem)
        //enkel telefoon
        //return oldItem.fields.telefoon == newItem.fields.telefoon
    }

}

//zet de scholen in overview scherm
class SchoolViewHolder(val binding: ListItemScholenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(school: SchoolEntity) {
        binding.school = school
    }

}


//wordt geimplementeerd in overviewFragment
interface SchoolClickListener{
    fun onSchoolClicked(school: SchoolEntity) //geeft school mee, en later de id

}