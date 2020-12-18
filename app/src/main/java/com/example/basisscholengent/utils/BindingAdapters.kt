package com.example.basisscholengent.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

//Binding adapters are responsible for making the appropriate framework calls to set values.
// One example is setting a property value like calling the setText() method.
// Another example is setting an event listener like calling the setOnClickListener() method.

//zo kunnen we in layout ->fragment.scholen.overview, de adapter meegeven dankzij "app:setAdaper= ..."
//"setAdaper" is naar attribuut die je gebruikt in je layout file
//kan je zien als een extension functie op RecyvlerView
@BindingAdapter(value = ["setAdapter"])
////we beperken het niet tot 1 bepaalde adapter, daardoor die sterretje(= algemene notatie)
fun RecyclerView.bindRecyvlerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.adapter = adapter //opvullen
    }
}