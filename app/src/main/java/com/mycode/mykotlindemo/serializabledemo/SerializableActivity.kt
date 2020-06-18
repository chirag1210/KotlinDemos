package com.mycode.mykotlindemo.serializabledemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mycode.mykotlindemo.R
import kotlinx.android.synthetic.main.activity_serializable.*
import java.io.Serializable

class SerializableActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serializable)

        button.setOnClickListener(this)
    }

    fun launchNextScreen(context: Context, student: Student) {
        val intent = Intent(context, DataReceivedActivity::class.java)
        intent.putExtra("student", student as Serializable)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                var student = Student("Chirag", "Pune")
                launchNextScreen(this, student)
            }
        }
    }
}