package com.snail.moduleinterfacedemo.factory

/**
 * 服务调度工厂
 */
class MediatorServiceFactory private constructor() : IServiceManager {
    private val mClassMap = HashMap<Any, ServiceClassData<*, *>>()

    companion object {
        val instance: MediatorServiceFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            MediatorServiceFactory()
        }
    }

    /**
     * 添加服务的实现类
     *
     * @param cls 接口class对象
     * @param implClass 实现类class对象
     */
    override fun <T, E : T> put(cls: Class<T>, implClass: Class<E>): IServiceManager {
        mClassMap[cls] = ServiceClassData(cls, implClass)
        return this
    }

    /**
     * 获取服务的实现类
     * @param cls 接口class对象
     */
    @Suppress("UNCHECKED_CAST")
    override fun <T, E : T> get(cls: Class<T>): E {
        val scd = mClassMap[cls]
        if (mClassMap[cls] == null) {
            throw NullPointerException("尚未注册，请在程序入口处使用put方法注册")
        }
        val data = scd as ServiceClassData<T, E>
        if (data.impl == null) {
            data.impl = data.implClass?.newInstance()
        }
        return data.impl as E
    }
}