package com.snail.moduleinterfacedemo.factory

interface IServiceManager {
    /**
     * 添加服务的实现类
     *
     * @param cls 接口class对象
     * @param implClass 实现类class对象
     */
    fun <T, E : T> put(cls: Class<T>, implClass: Class<E>): IServiceManager

    /**
     * 获取服务的实现类
     * @param cls 接口class对象
     */
    fun <T, E : T> get(cls: Class<T>): E
}