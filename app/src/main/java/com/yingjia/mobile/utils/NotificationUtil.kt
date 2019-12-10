package com.yingjia.mobile.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

/**
 * Created by 3ompact on 2019/10/10 18:06
 *
 * 通知工具类
 */
class NotificationUtil {

    private var context: Context? = null
    private var notificationManager: NotificationManager? = null
    private var ncBuilder: NotificationCompat.Builder? = null
    private var channelId: String? = null
    private var notification: Notification? = null
    private var channel: NotificationChannel? = null

    /**
     * @param channelId 频道id
     * @param context
     */
    constructor(context: Context, channelId: String) {
        this.context = context
        this.channelId = channelId

    }

    /**  发送一般性通知消息
     *@param smallIconId 小标资源id
     * @param contentInfo 提示类容
     * @param contentTitle 提示标题
     * @param intent 目标intent
     * @param uniqueId 唯一标识id
     */

    fun sendNormalNotificationMessage(
        smallIconId: Int,
        contentInfo: String,
        contentTitle: String,
        intent: PendingIntent,
        uniqueId: Int,
        channelName: String
    ) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notificationManager =
                (context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?)!!
            ncBuilder = NotificationCompat.Builder(context!!, channelId!!)
                .setSmallIcon(smallIconId)
                .setContentText(contentInfo)
                .setContentTitle(contentTitle)

            notification = ncBuilder!!.build()
            notification!!.contentIntent = intent
            notificationManager!!.notify(uniqueId, notification)
        } else {
            //适配8.0之后的通知 需要添加channel
            channel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_LOW)
            notificationManager =
                (context!!.getSystemService(Context.NOTIFICATION_SERVICE)) as NotificationManager
            notificationManager!!.createNotificationChannel(channel)
            ncBuilder = NotificationCompat.Builder(context!!, channelId!!)
                .setSmallIcon(smallIconId)
                .setContentTitle(contentTitle)
                .setContentText(contentInfo)

            notification = ncBuilder!!.build()
            notification!!.contentIntent = intent;
            notificationManager!!.notify(uniqueId, notification)

        }

    }
}