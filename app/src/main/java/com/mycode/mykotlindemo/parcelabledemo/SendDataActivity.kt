package com.mycode.mykotlindemo.parcelabledemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mycode.mykotlindemo.R
import kotlinx.android.synthetic.main.activity_serializable.*


/**
 * Notes: a
 */

class SendDataActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serializable)

        //Change actionbar title
        var action=supportActionBar
        action!!.title=getString(R.string.parcelable)

        button.setOnClickListener(this)
    }

    fun launchNextScreen(context: Context, student: Student) {
        val intent = Intent(context, GetDataActivity::class.java)
        intent.putExtra("studentData", student)
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