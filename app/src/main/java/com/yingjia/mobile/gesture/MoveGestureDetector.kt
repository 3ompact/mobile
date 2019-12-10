package com.yingjia.mobile.gesture

import android.content.Context
import android.graphics.PointF
import android.view.MotionEvent

/**
 * Created by 3ompact on 2019/10/29 16:49
 *
 */
class MoveGestureDetector(context: Context) : BaseGestureDetector(context) {


    private var mCurrentPointer: PointF? = null
    private var mPrePointer: PointF? = null
    private val mDeltaPointer: PointF = PointF()
    //用于记录最终结果，并返回
    private val mExtenalPointer: PointF = PointF()
    private val mListenter: OnMoveGestureListener? = null

    constructor(context: Context ,listener : OnMoveGestureListener ) : this(context) {

    }
    override fun handleInProgressEvent(event: MotionEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var actionCode = event.action and  MotionEvent.ACTION_MASK
        when(actionCode){
            MotionEvent.ACTION_CANCEL,MotionEvent.ACTION_UP -> {
                mListenter!!.onMove(this)
                resetState()}

            MotionEvent.ACTION_MOVE -> {
                updateStateByEvent(event)
                var update = mListenter!!.onMove(this)
                if(update){
                    mPreMotionEvent!!.recycle()
                    mPreMotionEvent = MotionEvent.obtain(event)
                }
            }
        }
    }

    override fun handleStartProgressEvent(event: MotionEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var actionCode = event.action and MotionEvent.ACTION_MASK
       when(actionCode){
           MotionEvent.ACTION_DOWN -> {
               resetState()//防止没有接收到CANCEL or UP ,保险起见
               mPreMotionEvent = MotionEvent.obtain(event)
               updateStateByEvent(event)
           }

           MotionEvent.ACTION_MOVE ->{
               mGestureInProgress = mListenter!!.onMoveBegin(this)
           }
       }
    }

    override fun updateStateByEvent(event: MotionEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val  prev : MotionEvent? = mPreMotionEvent
        mPrePointer = calculateFocalPointer(prev!!)
        mCurrentPointer = calculateFocalPointer(prev!!)
        var mSkipThisMoveEvent : Boolean = prev.pointerCount != event.pointerCount

        if(mSkipThisMoveEvent) {
            mExtenalPointer.x = 0f
        } else{
            mExtenalPointer.x = mCurrentPointer!!.x - mPrePointer!!.x
        }

        if(mSkipThisMoveEvent) {
            mExtenalPointer.y = 0f
        } else{
            mExtenalPointer.y = mCurrentPointer!!.y - mPrePointer!!.y
        }
    }


    private fun calculateFocalPointer(event : MotionEvent) : PointF{

        val count : Int = event.pointerCount
        var x : Float  = 0f
        var y : Float = 0f
        for (i in 0..count ){
            x += event.getX(i)
            y += event.getY(i)
        }
        x /= count
        y /= count

        return PointF(x,y)
    }

    /**
     * 获取x轴上的单位量
     */
    public fun getMoveX():Float{
        return mExtenalPointer.x
    }
    public fun getMoveY():Float{
        return mExtenalPointer.y
    }

    interface OnMoveGestureListener{
        public fun onMoveBegin(detector : MoveGestureDetector):Boolean
        public fun onMove(detector : MoveGestureDetector):Boolean
        public fun onMoveEnd(detector : MoveGestureDetector)
    }

    companion object{
         open class SimpleMoveGestureDetector() : OnMoveGestureListener{
             override fun onMoveBegin(detector: MoveGestureDetector) : Boolean {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return true
             }

             override fun onMove(detector: MoveGestureDetector):Boolean  {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return false
             }

             override fun onMoveEnd(detector: MoveGestureDetector) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

             }

         }
    }
}