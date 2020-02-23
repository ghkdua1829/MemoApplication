package com.example.memoapplication.feature.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.memoapplication.R
import com.example.memoapplication.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityAddBinding = DataBindingUtil.setContentView(this@AddActivity,R.layout.activity_add)


    }
}
