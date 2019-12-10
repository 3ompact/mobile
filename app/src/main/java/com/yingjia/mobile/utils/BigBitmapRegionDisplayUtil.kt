package com.yingjia.mobile.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapRegionDecoder
import android.graphics.Rect

/**
 * Created by 3ompact on 2019/10/29 13:56
 *  大图局部展示工具
 */
class BigBitmapRegionDisplayUtil {

    var bitmapReginDecoder : BitmapRegionDecoder? = null
    var optionsTemp : BitmapFactory.Options? = null
    var optionsDisplay : BitmapFactory.Options? = null

    var width :Int = 100
    var height :Int = 100
    var widthPic :Int = 0
    var heightPic :Int = 0
    /**
     * 设置输入流
     */
    fun setInputStream(filePath : String){
        initOptionsTemp(filePath)
        bitmapReginDecoder = BitmapRegionDecoder.newInstance(filePath,false)
    }

    /**
     * 设置显示选项
     */
//    public fun setDisplayRegion(width : Int,height :Int){
//        this.width = width
//        this.height = height
//    }


    /**
     * 设置显示范围
     */
    fun setRegionDisplay(width : Int,height :Int){
        this.width = width
        this.height = height
    }

    /**
     * 设置options
     */
    private fun setOptions(filePath : String){
        optionsDisplay = BitmapFactory.Options()
        optionsDisplay!!.inPreferredConfig = Bitmap.Config.RGB_565

    }

    fun getBitmap() : Bitmap{
        return bitmapReginDecoder!!.decodeRegion(
            Rect(width / 2 - 100, height / 2 - 100,
            width / 2 + 100, height / 2 + 100), optionsDisplay)
    }

    /**
     * 初始化 目标图片options
     */
    private fun initOptionsTemp(filePath : String){
        optionsTemp = BitmapFactory.Options()
        optionsTemp!!.inJustDecodeBounds = true
        BitmapFactory.decodeFile(filePath,optionsTemp)
        this.heightPic = optionsTemp!!.outHeight
        this.widthPic = optionsTemp!!.outWidth

    }
}