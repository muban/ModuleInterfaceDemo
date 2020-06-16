package com.snail.module_mediator.login

import android.util.Log
import com.snail.module_mediator.login.ILoginService

class LoginServiceImpl : ILoginService {
    override fun print() {
        Log.e("tag", "LoginServiceImpl")
    }

    override fun toast(str: String) {
        Log.e("toast", str)
    }
}