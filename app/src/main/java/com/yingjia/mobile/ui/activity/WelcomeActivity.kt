package com.yingjia.mobile.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.yingjia.mobile.R
import com.yingjia.mobile.databinding.ActivityWelcomeBinding
import com.yingjia.mobile.utils.ToastUtil

/**
 * Created by 3ompact on 2019/10/8 14:31
 *
 */
class WelcomeActivity : BaseActivity() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityWelcomeBinding>(this, R.layout.activity_welcome)
    }

    fun onClick(view: View){
        ToastUtil.show(this,"tes")
//        Toast.makeText(this,"111",Toast.LENGTH_SHORT).show()
    }

}