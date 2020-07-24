package com.snail.moduleinterfacedemo

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.snail.module_mediator.login.ILoginService
import com.snail.module_mediator.login.LoginServiceImpl
import com.snail.moduleinterfacedemo.factory.MediatorServiceFactory

class MApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //注册服务
        registerService()
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            // 打印日志
            ARouter.openLog()
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug()
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this)
    }

    private fun registerService() {
        MediatorServiceFactory.instance.put(ILoginService::class.java, LoginServiceImpl::class.java)
    }
}