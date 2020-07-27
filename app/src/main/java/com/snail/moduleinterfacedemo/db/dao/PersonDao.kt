package com.snail.moduleinterfacedemo.db.dao

import androidx.room.*
import com.snail.moduleinterfacedemo.db.entity.Person

@Dao
interface PersonDao {
    /**
     * 查询全部数据
     */
    @Query("SELECT * FROM person")
    fun getAll(): MutableList<Person>

    /**
     * 删除所有数据
     */
    @Query("DELETE FROM person")
    fun deleteAll()

    /**
     * OnConflictStrategy.REPLACE：冲突策略是取代旧数据同时继续事务
     * OnConflictStrategy.ROLLBACK：冲突策略是回滚事务
     * OnConflictStrategy.ABORT：冲突策略是终止事务（默认冲突策略）
     * OnConflictStrategy.FAIL：冲突策略是事务失败
     * OnConflictStrategy.IGNORE：冲突策略是忽略冲突
     */
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
    /**
     * 一次插入单条数据 或 多条
     */
    @Insert
    fun insert(vararg persons: Person)

    /**
     * 一次删除单条数据 或 多条
     */
    @Delete
    fun delete(vararg persons: Person)

    /**
     * 一次更新单条数据 或 多条
     */
    @Update
    fun update(vararg persons: Person)

    /**
     * 根据字段查询数据
     */
    @Query("SELECT * FROM person WHERE uid = :uid")
    fun getPersonById(uid: Long): Person

    /**
     * 根据字段查询多条数据
     */
    @Query("SELECT * FROM person WHERE uid IN (:userIds)")
    fun getPersonByIds(userIds: MutableList<Long>): MutableList<Person>

    /**
     * 根据多个条件查询
     */
    @Query("SELECT * FROM person WHERE name = :name AND age = :age")
    fun getPersonByNameAndAge(name: String, age: Int): Person
}