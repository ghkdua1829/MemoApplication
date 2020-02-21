package com.example.memoapplication.feature.movie

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.memoapplication.MemoAdapter
import com.example.memoapplication.data.model.Memo

@BindingAdapter("setData")
fun RecyclerView.setData(memoData: List<Any>?) {
    when (memoData) {
        null -> {

        }
        else -> {
            if (memoData.isNotEmpty()) {
                (this.adapter as MemoAdapter).setMemoData(memoData as List<Memo>)
            }
        }
    }
}