package com.yingjia.mobile

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy


/**
 * Created by 3ompact on 2019/10/10 17:11
 *
 */
class MyAplication : Application() {

    override fun onCreate() {
        super.onCreate()


        //初始化Logger
        var formatStrategy : FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .methodCount(0)
            .methodOffset(3)
            .tag("3ompact")
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

    }

}