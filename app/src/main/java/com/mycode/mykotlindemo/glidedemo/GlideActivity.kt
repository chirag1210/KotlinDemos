package com.mycode.mykotlindemo.glidedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mycode.mykotlindemo.R
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        //Change actionbar title
        var action=supportActionBar
        action!!.title=getString(R.string.glide_text)

        Glide.with(this)
            .load("https://i.imgur.com/qpr5LR2.jpg")
            .placeholder(R.drawable.progress_bar)
            .into(imageView);
    }

}