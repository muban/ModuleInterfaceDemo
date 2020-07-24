package com.snail.moduleinterfacedemo.entry

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

data class OneBean(
    @Bindable var title: String = "",
    @Bindable var content: String = ""
) : BaseObservable()