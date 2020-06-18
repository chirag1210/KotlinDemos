package com.mycode.mykotlindemo.recycledemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mycode.mykotlindemo.R

class MainActivity : AppCompatActivity(),
    CustomAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Change actionbar title
        var action=supportActionBar
        action!!.title=getString(R.string.recycle_view)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(
            getUserData(),
            this
        )
        recyclerView.adapter = adapter
    }

    private fun getUserData(): ArrayList<User> {
        val users = ArrayList<User>()
        for (i in 1..10) {
            users.add(
                User(
                    "Belal Khan",
                    "Ranchi Jharkhand"
                )
            )
            users.add(
                User(
                    "Ramiz Khan",
                    "Ranchi Jharkhand"
                )
            )
            users.add(
                User(
                    "Faiz Khan",
                    "Ranchi Jharkhand"
                )
            )
            users.add(
                User(
                    "Yashar Khan",
                    "Ranchi Jharkhand"
                )
            )
        }
        return users
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(applicationContext, "Position $position", Toast.LENGTH_SHORT).show()
    }

}