package com.firatveral.cakelist.utils

import android.app.Activity
import com.firatveral.cakelist.CakeApp

val Activity.cakeApp: CakeApp
    get() = application as CakeApp