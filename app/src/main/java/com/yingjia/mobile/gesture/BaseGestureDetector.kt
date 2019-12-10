package com.yingjia.mobile.gesture

import android.content.Context
import android.view.MotionEvent

/**
 * Created by 3ompact on 2019/10/29 16:06   手势操作基础类
 *
 */
abstract class BaseGestureDetector(context: Context) {

    protected var mGestureInProgress: Boolean = false
    protected var mPreMotionEvent: MotionEvent? = null
    protected var mCurrentMotionEvent: MotionEvent? = null
    protected var mContext: Context? = context

    /**
     * 初始化操作
     */
    init {

    }

    public fun onTouchEvent(event: MotionEvent): Boolean {
        if (!mGestureInProgress) {
            handleStartProgressEvent(event)
        } else {
            handleInProgressEvent(event)
        }
        return true
    }

    protected abstract fun handleInProgressEvent(event: MotionEvent)
    protected abstract fun handleStartProgressEvent(event: MotionEvent)
    //更新状态
    protected abstract fun updateStateByEvent(event: MotionEvent)


    protected fun resetState(){
        if(mPreMotionEvent != null){
            mPreMotionEvent!!.recycle()
            mPreMotionEvent = null
        }

        if(mCurrentMotionEvent != null){
            mCurrentMotionEvent!!.recycle()
            mCurrentMotionEvent = null
        }

        mGestureInProgress = false

    }


}