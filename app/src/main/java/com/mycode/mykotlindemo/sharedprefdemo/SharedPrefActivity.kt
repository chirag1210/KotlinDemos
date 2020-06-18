package com.mycode.mykotlindemo.sharedprefdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mycode.mykotlindemo.R
import kotlinx.android.synthetic.main.activity_shared_pref.*

class SharedPrefActivity : AppCompatActivity(), View.OnClickListener {

    private val KEY_NAME = "data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)
        //Change actionbar title
        var action=supportActionBar
        action!!.title=getString(R.string.shared_pref)

        val name = SharedPreference(this).getValueString(KEY_NAME)
        if (!name.isNullOrEmpty()) {
            editText.setText(name)
        }
        btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSave -> {
                SharedPreference(this).save(KEY_NAME, editText.text.toString())
            }
        }
    }

}