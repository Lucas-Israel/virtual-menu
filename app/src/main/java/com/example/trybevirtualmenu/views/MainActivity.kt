package com.example.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.PlateAdapter
import com.example.trybevirtualmenu.models.PlateDataBase

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val platesFromDB = PlateDataBase.getPlates()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PlateAdapter(platesFromDB)
    }
}
