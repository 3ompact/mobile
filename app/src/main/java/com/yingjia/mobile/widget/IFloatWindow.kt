package com.yingjia.mobile.widget

import android.view.View

/**
 * Created by 3ompact on 2019/12/10 16:11
 *
 */
abstract class IFloatWindow {

    //显示
    abstract fun show()
    //隐藏
    abstract fun hide()

    abstract fun isShowing(): Boolean

    abstract fun getX(): Int

     abstract fun getY(): Int

    abstract fun updateX(x:Int)

    abstract fun updateY(y:Int)

    abstract fun getView(): View?

    abstract fun dismiss()


}