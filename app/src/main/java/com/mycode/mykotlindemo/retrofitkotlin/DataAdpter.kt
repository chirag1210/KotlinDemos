package com.mycode.mykotlindemo.retrofitkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mycode.mykotlindemo.R
import com.mycode.mykotlindemo.retrofitkotlin.model.ResponseModel

class DataAdpter(
    private var dataList: List<ResponseModel>,
    private val context: Context,
    private val clickListener: (ResponseModel) -> Unit
) :
    RecyclerView.Adapter<DataAdpter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_recycleview, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)

        holder.textViewUsername.text = dataModel.id.toString()
        holder.textViewAddress.text = dataModel.title
        holder.itemView.setOnClickListener { clickListener(dataModel) }
    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        lateinit var textViewUsername: TextView
        lateinit var textViewAddress: TextView

        init {
            textViewUsername = itemLayoutView.findViewById(R.id.textViewUsername)
            textViewAddress = itemLayoutView.findViewById(R.id.textViewAddress)

        }

    }

}
