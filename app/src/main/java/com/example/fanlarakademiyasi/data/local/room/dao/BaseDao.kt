package com.example.fanlarakademiyasi.data.local.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(list: List<T>)

    @Update
    fun update(data: T)

    @Delete
    fun delete(data: T)
}