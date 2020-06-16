package com.snail.module_mediator.model

/**
 * 模型类
 */
open class BaseModel<T>(
    var data: T? = null,
    var code: Int? = 0,
    var message: String? = null
)