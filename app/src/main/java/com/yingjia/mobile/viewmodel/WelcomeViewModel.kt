package com.yingjia.mobile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by 3ompact on 2019/10/9 14:52  欢迎过度界面ViewModel
 *
 */
class WelcomeViewModel : ViewModel() {

    var url : MutableLiveData<String>? = null


    /**
     * 获取url
     */
    fun getUrl() : String {
        return url!!.value.toString()
    }

}