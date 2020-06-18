package com.mycode.mykotlindemo.serializabledemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mycode.mykotlindemo.R
import kotlinx.android.synthetic.main.activity_data_received.*

class DataReceivedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_received)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            bundle.apply {
                //Serializable Data
                val student = getSerializable("student") as Student?
                if (student != null) {
                    textView.text = "Student name is ${student?.name}. Address: ${student?.address}"
                }
            }
        }
    }
}