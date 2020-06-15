package com.snail.moduleinterfacedemo.factory

import com.snail.module_mediator.ILoginService
import com.snail.module_mediator.LoginServiceImpl

class Demo {
    fun test() {
        //
        MediatorServiceFactory.instance.put(ILoginService::class.java, LoginServiceImpl::class.java)
        //
        MediatorServiceFactory.instance.get(ILoginService::class.java)
    }
}