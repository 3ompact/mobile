package com.yingjia.mobile.widget

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.*


/**
 * Created by 3ompact on 2019/12/10 16:45
 *
 */
class FloatWindow {

    private fun FloatWindow() {

    }

    companion object {
        private val mDefaultTag: String = "default_float_window_tag"
        private var mFloatWindowMap: HashMap<String, IFloatWindow>? = null

        private var mBuilder: B? = null

        fun get(): IFloatWindow? {
            return get(mDefaultTag)
        }

        fun get(@NonNull tag: String): IFloatWindow? {
            if (mFloatWindowMap == null) {
                return null
            } else {

                return mFloatWindowMap!!.get(tag)
            }
        }

        fun with(@NonNull appllicationContext: Context): B? {
            mBuilder = B(appllicationContext)
            return mBuilder

        }

        fun destroy() {
            destroy(mDefaultTag)
        }

        fun destroy(tag: String) {

            if (mFloatWindowMap == null || !mFloatWindowMap!!.containsKey(tag)) {
                return
            }
            mFloatWindowMap!!.get(tag)!!.dismiss()
            mFloatWindowMap!!.remove(tag)
        }


    }

    class B {
        var mApplicationContext: Context? = null
        var view: View? = null
        private var mLayoutId: Int? = null
        private var mWidth = ViewGroup.LayoutParams.WRAP_CONTENT
        private var mHeight = ViewGroup.LayoutParams.WRAP_CONTENT
        var gravity: Int = Gravity.TOP or Gravity.START
        var xOffset: Int = 0
        var yOffset: Int = 0
        var mShow:Boolean  = true
        var mActivities:Array<AppCompatActivity>? = null
//        var mMoveType :Int =
        var mSlideLeftMargin:Int?= null
        var mSlideRightMargin:Int? = null
        constructor() {

        }

        constructor(applicationContext: Context) {

        }

    }
}