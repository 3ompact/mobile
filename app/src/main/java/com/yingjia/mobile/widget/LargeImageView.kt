package com.yingjia.mobile.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapRegionDecoder
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.yingjia.mobile.gesture.MoveGestureDetector
import com.yingjia.mobile.gesture.MoveGestureDetector.Companion.SimpleMoveGestureDetector
import java.io.IOException
import java.io.InputStream
import kotlin.math.roundToInt

/**
 * Created by 3ompact on 2019/10/29 14:53
 * 大图显示控件
 */
class LargeImageView  : View {

    constructor(context : Context):super(context){

    }

    constructor(context : Context, attrs:AttributeSet?=null):this(context){

    }

    constructor(context : Context, attrs:AttributeSet?=null,defStyleAttr : Int):this(context,attrs){
        inits()
//        val typedArray: TypedArray = context!!.obtainStyledAttributes(attrs, R.styleable.Bar)
    }

    private var mDecoder: BitmapRegionDecoder? = null
    private var mImageWidth: Int = 0
    private var mImageHeight: Int = 0
    @Volatile
    private var mRect: Rect = Rect()
    private var mDetector: MoveGestureDetector? = null

    companion object {
        private val options: BitmapFactory.Options = BitmapFactory.Options()

        init {
            //设置图片色彩模式
            options.inPreferredConfig = Bitmap.Config.RGB_565

        }

    }

    fun setInputStream(ins: InputStream) {

        try {
            mDecoder = BitmapRegionDecoder.newInstance(ins, false)
            var tempOptions: BitmapFactory.Options = BitmapFactory.Options()
            //只读取图片，不加载到内存中
            tempOptions.inJustDecodeBounds = true
            BitmapFactory.decodeStream(ins, null, tempOptions)
            mImageWidth = tempOptions.outWidth
            mImageHeight = tempOptions.outHeight

            requestLayout()
            invalidate()
        } catch (e: IOException) {

        } finally {

            if (ins != null) {
                ins.close()
            }
        }

    }

    /**
     * 初始化
     */
    fun inits() {
        mDetector = MoveGestureDetector(context,object :
            SimpleMoveGestureDetector() {
            override fun onMove(detector: MoveGestureDetector): Boolean {
                var moveX :Int = detector.getMoveX().roundToInt()
                var moveY :Int = detector.getMoveY().roundToInt()
                if(mImageWidth > width){
                    mRect.offset(-moveX,0)
                    checkWidth()
                    invalidate()
                }

                if (mImageHeight > getHeight())
                {
                    mRect.offset(0, -moveY)
                    checkHeight()
                    invalidate()
                }
                return true
            }
            })
    }



    private fun checkWidth(){
        var rect :Rect = mRect
        var imageWidth = mImageWidth
        var imageHeight = mImageHeight
        if(rect.right > imageWidth) {
            rect.right = imageWidth
            rect.left = imageWidth - getWidth()
        }

        if(rect.left < 0){
            rect.left = 0
            rect.right = width
        }

    }


    private fun checkHeight()
    {

        var rect = mRect
        var imageWidth = mImageWidth
        var imageHeight = mImageHeight

        if (rect.bottom > imageHeight)
        {
            rect.bottom = imageHeight
            rect.top = imageHeight - height
        }

        if (rect.top < 0)
        {
            rect.top = 0
            rect.bottom = height
        }
    }



}