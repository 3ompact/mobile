package com.yingjia.mobile.utils

import android.content.Context
import android.view.View
import android.widget.Toast

/**
 * Created by 3ompact on 2019/10/10 14:33
 * Toast 简易封装工具类
 *
 */
class ToastPrompt {

    /**
     * toast 显示在顶部 默认为短提示
     * @param tips toast显示文字
     * @param localType 设置toast弹出位置
     * @param offsetX x轴偏移位置
     * @param offsetY y轴偏移位置
     * @param duration 设置显示时常
     */
    fun showTaost(context: Context, tips: String, localType: Int, offsetX: Int, offsetY: Int,duration : Int = -1) {

        var toast = Toast(context)
        //设置想x，y的偏移量为0
        toast.setGravity(localType, offsetX, offsetY)
        toast.duration = if(duration == -1){Toast.LENGTH_SHORT}else{Toast.LENGTH_SHORT}
        toast.setText(tips)
        toast.show()
    }

    /**
     * 自定义界面的toast   默认为短提示
     * @param localType 设置toast弹出位置
     * @param view 自定义view
     * @param offsetX x轴偏移位置
     * @param offsetY y轴偏移位置
     * @param duration 设置显示时常
     *
     */
    fun showCustomToast(context: Context, view: View, localType: Int, offsetX: Int, offsetY: Int,duration : Int = -1) {
        if (null == view) {
            return
        }
        var toast = Toast(context)
        //设置想x，y的偏移量为0
        toast.setGravity(localType, offsetX, offsetY)
        toast.duration = if(duration == -1){Toast.LENGTH_SHORT}else{Toast.LENGTH_SHORT}
        toast.view = view
        toast.show()
    }
}