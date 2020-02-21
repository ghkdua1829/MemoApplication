package com.example.memoapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.memoapplication.data.model.Memo
import com.example.memoapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val list: List<Memo> = (listOf(
        Memo(
            title = "ASda", description = "asdsa", date = "asd"
        ), Memo(title = "ASda", description = "asdsa", date = "asd")
    ))
    private lateinit var memoAdapter: MemoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        memoAdapter = MemoAdapter()
        memoAdapter.setMemoData(list)
        binding.rvMemo.adapter = memoAdapter

    }
}
