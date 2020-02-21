package com.example.memoapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memoapplication.data.model.Memo
import com.example.memoapplication.databinding.ItemMemoBinding

class MemoAdapter() : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {
    private val memoData: ArrayList<Memo> = ArrayList();

    fun setMemoData(newMemoData: List<Memo>) {
        with(memoData) {
            clear()
            addAll(newMemoData)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val binding: ItemMemoBinding =
            ItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return memoData.size
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(memoData[position])
    }

    class MemoViewHolder(private val memoBinding: ItemMemoBinding) :
        RecyclerView.ViewHolder(memoBinding.root) {

        fun bind(memo: Memo) {
            memoBinding.memo = memo
        }
    }

}