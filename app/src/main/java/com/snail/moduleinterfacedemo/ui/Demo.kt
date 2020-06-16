package com.snail.moduleinterfacedemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.snail.module_mediator.login.ILoginService
import com.snail.moduleinterfacedemo.factory.MediatorServiceFactory

class Demo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        test()
    }

    private fun test() {
        //测试打印
        MediatorServiceFactory.instance.get(ILoginService::class.java)
            .print()
        MediatorServiceFactory.instance.get(ILoginService::class.java)
            .toast("test toast str")

    }
}