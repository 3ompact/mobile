package com.yingjia.mobile.widget

import android.animation.TimeInterpolator
import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import java.lang.IllegalArgumentException
import java.util.zip.Inflater
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
        var mView: View? = null
        private var mLayoutId: Int? = null
        var mWidth = ViewGroup.LayoutParams.WRAP_CONTENT
        var mHeight = ViewGroup.LayoutParams.WRAP_CONTENT
        var gravity: Int = Gravity.TOP or Gravity.START
        var xOffset: Int = 0
        var yOffset: Int = 0
        var mShow: Boolean = true
        var mActivities: Array<AppCompatActivity>? = null
        var mMoveType: Int = 0
        var mSlideLeftMargin: Int? = null
        var mSlideRightMargin: Int? = null
        var mDuration: Long = 300
        var mInterpolator: TimeInterpolator? = null
        private var mTag: String = mDefaultTag
        var mDesktopShow: Boolean? = null


        constructor() {

        }

        constructor(applicationContext: Context) {

        }

        fun setView(@NonNull view: View): B {
            mView = view
            return this
        }

        fun setView(layoutId: Int): B {
            mLayoutId = layoutId
            return this
        }

        fun setWidth(width: Int): B {
            mWidth = width
            return this
        }

        fun setHeight(height: Int): B {
            mHeight = height
            return this
        }

        fun setWidth(ratio: Float, width: Int): B {
            mWidth = width * ratio as Int
            return this
        }

        fun setHeight(ratio: Float, height: Int): B {
            mWidth = height * ratio as Int
            return this
        }

        fun setX(x: Int): B {
            xOffset = x
            return this
        }

        fun setY(y: Int): B {
            yOffset = y
            return this
        }

        fun setX(ratio: Float, x: Int): B {
            xOffset = x * ratio as Int
            return this
        }

        fun setY(ratio: Float, y: Int): B {
            yOffset = y * ratio as Int
            return this
        }

        /**
         * 设置Activity过滤器，用于指定那些界面显示悬浮
         */
        fun setFilter(show: Boolean, activities: Array<AppCompatActivity>): B {
            mShow = show
            mActivities = activities
            return this
        }

        fun setMoveType(moveType: Int): B {
            return setMoveType(moveType, 0, 0)

        }

        /**
         * 设置带边距的贴边动画 moveType为移动类型
         */
        fun setMoveType(moveType: Int, slideLeftMargin: Int, slideRightMargin: Int): B {
            mMoveType = moveType
            mSlideLeftMargin = slideLeftMargin
            mSlideRightMargin = slideRightMargin
            return this

        }

        fun setMoveStyle(duration: Long, timeInterpolator: TimeInterpolator): B {
            mDuration = duration
            mInterpolator = timeInterpolator
            return this

        }

        fun setTag(tag: String): B {
            mTag = tag
            return this
        }

        fun setDesktopShow(show: Boolean): B {
            mDesktopShow = show
            return this
        }

        fun build() {
            if (mFloatWindowMap == null) {
                mFloatWindowMap = HashMap()
            }

            if (mFloatWindowMap!!.containsKey(mTag)) {
                throw IllegalArgumentException(
                    "FloatWindow of this tag has been added," +
                            "Please add a new tag for the new FloatWindow"
                )
            }

            if (mView == null && mLayoutId == 0) {
                throw IllegalArgumentException("View has not been set!")
            }
            if (mView == null) {
                mView =
                    ((mApplicationContext!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)) as LayoutInflater).inflate(
                        mLayoutId!!,
                        null
                    )
            }

            var floatWindowImpl: IFloatWindow = IFloatWindowImp(this)
            mFloatWindowMap!!.put(mTag, floatWindowImpl);
        }


    }
}