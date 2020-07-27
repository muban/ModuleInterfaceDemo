package com.snail.moduleinterfacedemo.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.snail.moduleinterfacedemo.db.dao.PersonDao
import com.snail.moduleinterfacedemo.db.entity.Person

@Database(entities = [Person::class], version = 1)
abstract class DemoDataBase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}