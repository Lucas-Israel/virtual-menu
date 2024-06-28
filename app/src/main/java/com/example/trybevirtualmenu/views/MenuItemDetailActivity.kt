package com.example.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.models.PlateDataBase
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class MenuItemDetailActivity : AppCompatActivity() {

    private val img: ShapeableImageView by lazy { findViewById(R.id.detail_image) }
    private val nome: MaterialTextView by lazy { findViewById(R.id.detail_name) }
    private val desc: MaterialTextView by lazy { findViewById(R.id.detail_description) }
    private val price: MaterialTextView by lazy { findViewById(R.id.detail_price) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item_detail)

        val plateId = intent.getIntExtra("id", 0)
        val plate = PlateDataBase.getPlateById(plateId)

        if (plate != null) {
            img.setImageResource(plate.img)
            nome.text = plate.name
            desc.text = plate.desc
            price.text = plate.price.toString()
        }
    }
}
