package com.yingjia.mobile.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast


/**
 * Created by 3ompact on 2019/11/6 14:17   toast 工具类
 *
 */
class ToastUtil {
    companion object {

        /**
         * 短提示
         * @param msg
         * @param context
         */
        fun showShort(msg:String,context:Context){
//            Toast.
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()

        }
        /**
         * 长提示
         * @param msg
         * @param context
         */
        fun showLong(msg:String,context:Context){
            Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
        }

        class Builder {
            private var context: Context? = null
        }

        private var context: Context? = null
        fun show(context: Context, msg: String) {
            this.context = context

            showPrompt(toast!!, msg)
        }

        private var toast: Toast? = null
            get() {
                if (field == null) {
                    field = Toast(context)
                } else {
//                    field!!.cancel()

                }
                return field
            }

        /**
         * 显示提示消息
         */
        fun showPrompt(msg: String) {
            toast!!.setText(msg)
            toast!!.duration = Toast.LENGTH_SHORT
            toast!!.setGravity(Gravity.CENTER, 0, 0)
            toast!!.show()
        }

        /**
         * 显示提示消息
         */
        fun showPrompt(toast: Toast, msg: String) {
            toast!!.setText(msg)
            toast!!.duration = Toast.LENGTH_SHORT
            toast!!.setGravity(Gravity.CENTER, 0, 0)
            toast!!.show()
        }

        private var instance: ToastUtil? = null
            get() {
                if (field == null) {
                    field = ToastUtil()
                }
                return field
            }

        fun get(): ToastUtil {
            return instance!!
        }
    }

}