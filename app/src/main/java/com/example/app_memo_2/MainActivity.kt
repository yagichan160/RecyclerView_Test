package com.example.app_memo_2

import RecycllerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() , RecyclerViewHolder.ItemClickListnear{

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ここでエラー「Unresolved reference:array」 でコンパイルが通らない。
        // arrayが良くないのだと思いますがよくわかりません。
        val hoges = resources.getStringArray(R.array<String>.hoges).toMutableList()

        viewAdapter = RecycllerAdapter(this, this, hoges)
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView = findViewById<RecyclerView>(R.id.mainRecyclerView).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter
        }
    }


    override  fun onItemClick(view:View,position:Int){

        Toast.makeText(applicationContext,"position $position was tapped",Toast.LENGTH_SHORT).show()

    }
}
