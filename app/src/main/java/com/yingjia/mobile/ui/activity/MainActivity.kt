package com.yingjia.mobile.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.yingjia.mobile.R
import com.yingjia.mobile.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }

    override fun checkConfig() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showContent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPrompt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroyDoSomething() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
