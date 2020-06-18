package com.mycode.mykotlindemo.parcelabledemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mycode.mykotlindemo.R
import kotlinx.android.synthetic.main.activity_data_received.*

class GetDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_received)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            bundle.apply {
                //Parcelable Data
                val student: Student? = getParcelable("studentData")
                if (student != null) {
                    textView.text = "Name is ${student?.name}. Age: ${student?.address}"
                }
            }
        }
    }
}