package com.example.trybevirtualmenu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.interfaces.PlateItemListener
import com.example.trybevirtualmenu.models.Plate
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class PlateAdapter(private val plates: List<Plate>) : Adapter<PlateAdapter.PlateViewHolder>() {

    private var plateListener: PlateItemListener? = null

    fun setPlateListener(listener: PlateItemListener) {
        this.plateListener = listener
    }

    class PlateViewHolder(view: View, plateListener: PlateItemListener?) : ViewHolder(view) {
        val nome: MaterialTextView = view.findViewById(R.id.item_menu_name)
        val image: ShapeableImageView = view.findViewById(R.id.item_menu_image)

        init {
            view.setOnClickListener {
                plateListener?.onPlateClick(view, bindingAdapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_menu_layout, parent, false)
        return PlateViewHolder(view, plateListener)
    }

    override fun getItemCount(): Int = plates.size

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        holder.nome.text = plates[position].name
        holder.image.setImageResource(plates[position].img)
    }
}