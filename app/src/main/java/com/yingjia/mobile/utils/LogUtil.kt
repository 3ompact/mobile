package com.yingjia.mobile.utils

import com.orhanobut.logger.Logger

/**
 * Created by 3ompact on 2019/10/10 14:52
 *
 * log封装工具
 */

class LogUtil {
    companion object {
        val isDebug = true

        fun debugPattern(tag: String, msg: String) {
            if (isDebug) {
                Logger.d(tag, msg)
            }
        }

        fun debugPattern(msg: String) {
            if (isDebug) {
                Logger.d("3ompact", msg)
            }
        }

        fun infoPattern(tag: String, msg: String) {
            if (isDebug) {
                Logger.i(tag, msg)
            }
        }

        fun infoPattern(msg: String) {
            if (isDebug) {
                Logger.i("3ompact", msg)
            }
        }
    }

}