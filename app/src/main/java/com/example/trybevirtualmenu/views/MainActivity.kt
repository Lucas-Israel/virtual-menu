package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.PlateAdapter
import com.example.trybevirtualmenu.interfaces.PlateItemListener
import com.example.trybevirtualmenu.models.PlateDataBase

class MainActivity : AppCompatActivity(), PlateItemListener {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val platesFromDB = PlateDataBase.getPlates()
        val adapter = PlateAdapter(platesFromDB)
        adapter.setPlateListener(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onPlateClick(view: View, position: Int) {
        val it = Intent(baseContext, MenuItemDetailActivity::class.java)
        it.putExtra("id", position)
        startActivity(it)
    }
}
