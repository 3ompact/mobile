package com.yingjia.mobile.widget

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.view.WindowManager

/**
 * Created by 3ompact on 2019/12/10 16:08 悬浮窗控件
 *
 */
class IFloatWindowImp : IFloatWindow {

    private var mB: FloatWindow.B? = null
    lateinit var mWindowManager: WindowManager
    lateinit var mLayoutParams: WindowManager.LayoutParams

    constructor(b: FloatWindow.B) {
        mB = b
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            mWindowManager =
                b.mApplicationContext!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            mLayoutParams = WindowManager.LayoutParams()
            mLayoutParams.format = PixelFormat.RGBA_8888
            mLayoutParams.flags = (WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                    or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            mLayoutParams.windowAnimations = 0
            mLayoutParams.width = b.mWidth
            mLayoutParams.height = b.mHeight
            mLayoutParams.gravity = b.gravity
            mLayoutParams.x = b.xOffset

        }

    }

    override fun show() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hide() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isShowing(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getX(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getY(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateX(x: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateY(y: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismiss() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}