package com.mycode.mykotlindemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mycode.mykotlindemo.glidedemo.GlideActivity
import com.mycode.mykotlindemo.parcelabledemo.SendDataActivity
import com.mycode.mykotlindemo.permission.PermissionActivity
import com.mycode.mykotlindemo.recycledemo.MainActivity
import com.mycode.mykotlindemo.retrofitkotlin.RetrofitActivity
import com.mycode.mykotlindemo.serializabledemo.SerializableActivity
import com.mycode.mykotlindemo.sharedprefdemo.SharedPrefActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        //Change actionbar title
        var action=supportActionBar
        action!!.title="Home"

        btnRecycleView.setOnClickListener(this)
        btnSerializable.setOnClickListener(this)
        btnParcelable.setOnClickListener(this)
        btnSharedPref.setOnClickListener(this)
        btnRetrofit.setOnClickListener(this)
        btnGlide.setOnClickListener(this)
        btnPermission.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRecycleView -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.btnSerializable -> {
                val intent = Intent(this, SerializableActivity::class.java)
                startActivity(intent)
            }
            R.id.btnParcelable -> {
                val intent = Intent(this, SendDataActivity::class.java)
                startActivity(intent)
            }
            R.id.btnSharedPref -> {
                val intent = Intent(this, SharedPrefActivity::class.java)
                startActivity(intent)
            }
            R.id.btnRetrofit -> {
                val intent = Intent(this, RetrofitActivity::class.java)
                startActivity(intent)
            }
            R.id.btnGlide -> {
                val intent = Intent(this, GlideActivity::class.java)
                startActivity(intent)
            }
            R.id.btnPermission -> {
                val intent = Intent(this, PermissionActivity::class.java)
                startActivity(intent)
            }
            else -> {
            }
        }
    }
}