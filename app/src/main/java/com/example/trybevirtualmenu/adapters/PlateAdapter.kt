package com.example.trybevirtualmenu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.models.Plate
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class PlateAdapter(private val plates: List<Plate>) : Adapter<PlateAdapter.PlateViewHolder>() {

    class PlateViewHolder(view: View) : ViewHolder(view) {
        val nome: MaterialTextView = view.findViewById(R.id.item_menu_name)
        val image: ShapeableImageView = view.findViewById(R.id.item_menu_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_menu_layout, parent, false)
        return PlateViewHolder(view)
    }

    override fun getItemCount(): Int = plates.size

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        holder.nome.text = plates[position].name
        holder.image.setImageResource(plates[position].img)
    }
}