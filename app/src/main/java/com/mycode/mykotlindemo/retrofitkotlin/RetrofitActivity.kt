package com.mycode.mykotlindemo.retrofitkotlin

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mycode.mykotlindemo.R
import com.mycode.mykotlindemo.retrofitkotlin.model.ResponseModel
import com.mycode.mykotlindemo.retrofitkotlin.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    lateinit var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList<ResponseModel>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        //Change actionbar title
        var action=supportActionBar
        action!!.title=getString(R.string.retrofit)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)

        //setting up the adapter
        recyclerView.adapter = DataAdpter(dataList, this,{selectedItem: ResponseModel -> listItemClicked(selectedItem)})
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        progerssProgressDialog = ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getData()
    }

    private fun getData() {
        val call: Call<List<ResponseModel>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<ResponseModel>> {

            override fun onResponse(
                call: Call<List<ResponseModel>>?,
                response: Response<List<ResponseModel>>?
            ) {
                progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<ResponseModel>>?, t: Throwable?) {
                progerssProgressDialog.dismiss()
            }
        })
    }
    private fun listItemClicked(responseModel: ResponseModel){
        Toast.makeText(this,
            "Clicked Item is ${responseModel.title}",Toast.LENGTH_LONG).show()
    }
}