package com.snail.module_mediator

import android.util.Log

class LoginServiceImpl : ILoginService {
    override fun print() {
        Log.e("tag", "msg")
    }
}