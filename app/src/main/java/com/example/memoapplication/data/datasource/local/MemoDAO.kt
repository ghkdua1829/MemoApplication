package com.example.memoapplication.data.datasource.local

import androidx.room.*
import com.example.memoapplication.data.model.Memo

@Dao
interface MemoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMemo(vararg memos: Memo)

    @Delete
    fun deleteMemo(vararg memos: Memo)

    @Query("SELECT * FROM memo")
    fun loadAllMemo(): List<Memo>

    @Query("SELECT * FROM memo WHERE id=:id")
    fun viewOneMemo(id: Int): Memo

}