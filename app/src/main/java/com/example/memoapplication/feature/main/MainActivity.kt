package com.example.memoapplication.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.memoapplication.R
import com.example.memoapplication.data.datasource.local.MemoDatabase
import com.example.memoapplication.data.model.Memo
import com.example.memoapplication.databinding.ActivityMainBinding
import com.example.memoapplication.feature.add.AddActivity

class MainActivity : AppCompatActivity() {
    private var memoDatabase: MemoDatabase? = null
    lateinit var memoList: List<Memo>
    private lateinit var memoAdapter: MemoAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this@MainActivity,
                R.layout.activity_main
            )

        goAddActivity()

        memoAdapter = MemoAdapter()
        binding.rvMemo.adapter = memoAdapter

        memoDatabase = MemoDatabase.getInstance(this@MainActivity)

        val add = Runnable {
            memoDatabase?.MemoDao()?.insertMemo(Memo(id = 2,title = "나의 일",description = "오늘은 집돌이모드",date = "today"))
        }

        val addThread = Thread(add)
        addThread.start()
        var r = Runnable {
            memoList = memoDatabase?.MemoDao()?.loadAllMemo()!!
            memoAdapter.setMemoData(memoList)
        }

        val thread =Thread(r)
        thread.start()
    }

    private fun goAddActivity(){
        binding.addBtn.setOnClickListener {
            val intentssss = Intent(this@MainActivity,AddActivity::class.java)
            startActivity(intentssss)
        }
    }
}
