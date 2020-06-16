package com.snail.moduleinterfacedemo

import android.app.Application
import com.snail.module_mediator.login.ILoginService
import com.snail.module_mediator.login.LoginServiceImpl
import com.snail.moduleinterfacedemo.factory.MediatorServiceFactory

class MApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //注册服务
        registerService()
    }

    private fun registerService() {
        MediatorServiceFactory.instance.put(ILoginService::class.java, LoginServiceImpl::class.java)
    }
}