package com.yingjia.mobile.utils

import android.content.Context

/**
 * Created by 3ompact on 2019/10/10 10:56 小工具类
 *
 */
class ScreenSmallUtil {

    companion object {

        /**
         * 像素单位dp转为px
         * @param dp 一般长度单位
         * @param context 上下文
         */
        fun dp2px(dp: Int, context: Context): Float {
            var density = context.resources.displayMetrics.density
            return dp * density
        }

        /**
         * 像素单位px转为dp
         * @param px 像素单位
         * @param context 上下文
         */
        fun px2dp(px: Int, context: Context): Float {
            var density = context.resources.displayMetrics.density
            return px / density
        }


        /**
         * 获取每英寸密度
         * @param context 上下文
         */
        fun getDensity(context: Context): Float {
            return context.resources.displayMetrics.density
        }

        /**
         * 单位英寸像素个数
         * @param context 上下文
         */
        fun getDensityDpi(context: Context): Int {
            return context.resources.displayMetrics.densityDpi
        }

        /**
         * 获取宽度（像素） 会随着屏幕旋转 改变
         */
        fun getScreenWidth(context: Context): Int {
            return context.resources.displayMetrics.widthPixels
        }

        /**
         * 获取高度（像素） 会随着屏幕旋转 改变
         */
        fun getScreenHeight(context: Context): Int {
            return context.resources.displayMetrics.heightPixels
        }

    }

}