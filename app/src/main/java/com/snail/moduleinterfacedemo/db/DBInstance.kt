package com.snail.moduleinterfacedemo.db

import androidx.room.Room
import com.snail.moduleinterfacedemo.MApp
import com.snail.moduleinterfacedemo.db.database.DemoDataBase

class DBInstance {
    companion object {
        private const val DB_NAME = "muban_db_demo"
        private lateinit var demoDataBase: DemoDataBase
        val instance: DBInstance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            DBInstance()
        }
    }

    init {
        demoDataBase = Room.databaseBuilder(MApp.instance, DemoDataBase::class.java, DB_NAME)
            //下面注释表示允许主线程进行数据库操作，但是不推荐这样做。
            //我这里是为了Demo展示，稍后会结束和LiveData和RxJava的使用
//                .allowMainThreadQueries()
            .build()
    }

    /**
     * 获取数据库操作类
     */
    fun dataBase() = demoDataBase
}