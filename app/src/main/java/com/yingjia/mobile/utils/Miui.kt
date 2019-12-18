package com.yingjia.mobile.utils

import android.os.Build

/**
 * Created by 3ompact on 2019/12/18 10:16
 *
 */
class Miui {

    companion object{
        val miui :String = "ro.miui.ui.version.name"
        val miui5 :String = "V5"
        val miui6 :String = "V6"
        val miui7 :String = "V7"
        val miui8 :String = "V8"
        val miui9 :String = "V9"

        fun rom():Boolean{
            return Build.MANUFACTURER.equals("Xiaomi")
        }

        private fun getProp():String{
            return (Rom.getProp(miui))!!
        }
    }
}