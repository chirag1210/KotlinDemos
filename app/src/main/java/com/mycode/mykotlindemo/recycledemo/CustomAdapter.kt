package com.mycode.mykotlindemo.recycledemo

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mycode.mykotlindemo.R

class CustomAdapter(
    private val userList: ArrayList<User>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var selectedItemPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycleview, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewName.text = userList[position].name
        holder.textViewAddress.text = userList[position].address
        holder.itemView.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()
            listener.onItemClick(position)
        }
        if (selectedItemPosition == position) {
            holder.cardView.setBackgroundColor(Color.parseColor("#FED07A"))
        } else {
            holder.cardView.setBackgroundColor(Color.parseColor("#ffffff"))
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is holding the views
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
        val textViewAddress = itemView.findViewById(R.id.textViewAddress) as TextView
        val cardView = itemView.findViewById(R.id.cardView) as CardView
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}