package com.snail.moduleinterfacedemo.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true) var uid: Long? = 0,
    var name: String = "",
    var age: Int = 0,
    var sex: Int = 0
)