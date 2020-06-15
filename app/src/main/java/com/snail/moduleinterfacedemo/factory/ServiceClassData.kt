package com.snail.moduleinterfacedemo.factory

data class ServiceClassData<T, E : T>(
    //接口类
    var cls: Class<T>? = null,
    //实现类
    var implClass: Class<E>? = null,
    //实现类实例
    var impl: E? = null
)