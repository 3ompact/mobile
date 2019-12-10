package com.yingjia.mobile.ui.activity

import androidx.appcompat.app.AppCompatActivity

/**
 * Created by 3ompact on 2019/10/8 14:32
 *
 */
open abstract class BaseActivity : AppCompatActivity() {

    /**
     * 检查当前所需配置
     */
    abstract fun checkConfig() : Unit

    /**
     * 对不同情况下页面类容显示或是切换
     */
    abstract fun showContent()


    /**
     * 展示提示消息
     */
    abstract fun showPrompt()


    /**
     * 在ondestroy生命周期进行一些动作处理
     */

    abstract fun destroyDoSomething()

    override fun onDestroy() {
        super.onDestroy()
        destroyDoSomething()
    }
}