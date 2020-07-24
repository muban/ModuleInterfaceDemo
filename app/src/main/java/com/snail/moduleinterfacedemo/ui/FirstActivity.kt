package com.snail.moduleinterfacedemo.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.snail.moduleinterfacedemo.R
import com.snail.moduleinterfacedemo.constant.RouterPath
import com.snail.moduleinterfacedemo.databinding.FirstBinding
import com.snail.moduleinterfacedemo.entry.OneBean

@Route(path = RouterPath.FIRST_ACTIVITY)
class FirstActivity : AppCompatActivity() {

    private lateinit var mDataBinding: FirstBinding
    private val mSecond = OneBean("默认文字")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_first)
        mDataBinding.name = "data binding"
        mDataBinding.second = mSecond
        mDataBinding.setClick {
            mDataBinding.name = "click to change data"
            mSecond.title = "点击文字"
            mSecond.notifyChange()
            Toast.makeText(this@FirstActivity, "click binding", Toast.LENGTH_SHORT).show()
        }
    }

    fun funcTest(view: View) {
        Toast.makeText(this@FirstActivity, "funcTest", Toast.LENGTH_SHORT).show()
    }
}