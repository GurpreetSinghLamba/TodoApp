package com.gurpreet.todo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface todoDao {
    @Insert()
    suspend fun insertTask(todoModel: todoModel):Long

    @Query("select * from todoModel where isFinished!=0")
    fun getTask():LiveData<List<todoModel>>

    @Query("Update todoModel set isFinished=1 where id=:uid")
    fun finishTask(uid:Long)

    @Query("delete from todoModel where id=:uid")
    fun deleteTask(uid:Long)
}