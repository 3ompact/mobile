package com.yingjia.mobile.utils

import android.content.Context
import android.net.*
import android.net.ConnectivityManager
import android.os.Build
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi


/**
 * Created by 3ompact on 2019/10/8 14:47  网络情况工具
 *
 */
class NetworkUtil {

    companion object {

        val NETWORK_NONE: Int = 0 // 没有网络连接
        val NETWORK_WIFI: Int = 1 // wifi连接
        val NETWORK_2G: Int = 2 // 2G
        val NETWORK_3G: Int = 3 // 3G
        val NETWORK_4G: Int = 4 // 4G
        val NETWORK_MOBILE: Int = 5 // 手机流量

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun getNetworkIsAvailable(context: Context): Boolean {
            var con = context.getSystemService(Context.CONNECTIVITY_SERVICE)
            var conm = (con as ConnectivityManager)
            var network = (con as ConnectivityManager).allNetworks

            if (conm != null) {

                NetworkCapabilities(conm.getNetworkCapabilities(network[1])).hasTransport(
                    NetworkCapabilities.TRANSPORT_WIFI
                )
                return conm.getNetworkCapabilities(network[1])
                    .hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            }
            return false
        }

        /**
         * 获取运营商相关消息   需求版本6.0之后的
         * @param context
         */
        fun getOperatorName(context: Context): String {
            var tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            return tm.simOperatorName
        }

        /**
         * 获取当前网络连接类型
         */
        @RequiresApi(Build.VERSION_CODES.M)
        fun getNetworkState(context: Context): Int {

//            var networkCallback : NetworkCallback = NetworkCallback()

            var cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (null == cm) {
                return NETWORK_NONE
            }
            var networkInfo = cm.activeNetworkInfo
//            var activeNetworkInfo = (cm as ConnectivityManager).activeNetworkInfo
//            var activeNetwork = (cm as ConnectivityManager).activeNetwork

            var networkAvailable = cm.getNetworkCapabilities(cm.activeNetwork)
                .hasTransport(NetworkCapabilities.TRANSPORT_WIFI)

            if (networkInfo == null || !networkAvailable) {
                return NETWORK_NONE
            }
            //较高版本才能适配sdk24
//            if(networkInfo == null || !cm.registerDefaultNetworkCallback(networkCallback)){
//                return NETWORK_NONE
//            }
            //判断是否为Wifi
            var allNetworks = cm.allNetworks

//            var allNetworksInfo = cm.allNetworkInfo

            for (network in allNetworks) {
//                cm.getNetworkInfo(network).typeName
                var name = cm.getNetworkCapabilities(network)
                    .hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                if (name) {
                    return NETWORK_WIFI
                }
            }

            var telephonyManager =
                context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            var networkType = telephonyManager.networkType
            when (networkType) {
                TelephonyManager.NETWORK_TYPE_GPRS -> return NETWORK_2G
                TelephonyManager.NETWORK_TYPE_CDMA -> return NETWORK_2G
                TelephonyManager.NETWORK_TYPE_EDGE -> return NETWORK_2G
                TelephonyManager.NETWORK_TYPE_1xRTT -> return NETWORK_2G
                TelephonyManager.NETWORK_TYPE_IDEN -> return NETWORK_2G

                TelephonyManager.NETWORK_TYPE_EVDO_A -> return NETWORK_3G
                TelephonyManager.NETWORK_TYPE_UMTS -> return NETWORK_3G
                TelephonyManager.NETWORK_TYPE_EVDO_0 -> return NETWORK_3G
                TelephonyManager.NETWORK_TYPE_HSDPA -> return NETWORK_3G
                TelephonyManager.NETWORK_TYPE_HSUPA -> return NETWORK_3G
                TelephonyManager.NETWORK_TYPE_HSPA -> return NETWORK_3G
                TelephonyManager.NETWORK_TYPE_EVDO_B -> return NETWORK_3G
                TelephonyManager.NETWORK_TYPE_EHRPD -> return NETWORK_3G
                TelephonyManager.NETWORK_TYPE_HSPAP -> return NETWORK_3G

                TelephonyManager.NETWORK_TYPE_LTE -> return NETWORK_4G
                else -> return NETWORK_MOBILE
            }
        }


        /**
         * 判断网络是否连接  需求版本5.1之后的
         */
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun isNetConnected(context: Context): Boolean {
            var cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            var networkCallback : NetworkCallback = NetworkCallback()

            if (cm != null) {
                var networkInfo = cm.activeNetworkInfo

                if (networkInfo != null && networkInfo.isConnected) {
                    //需要较高版本支持  暂时去掉
//                    cm.registerDefaultNetworkCallback(networkCallback)
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true
                    }
                }
            }
            return false
        }


        /**
         * 判断是否wifi连接
         * @param context
         */
        fun isWifiConnected(context: Context): Boolean {

            var cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (cm != null) {
                var netInfo = cm.activeNetworkInfo
                if (netInfo != null) {
                    if (netInfo.getType() == ConnectivityManager.TYPE_WIFI || netInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
                        return netInfo.isConnected()
                    }
                }
            }
            return false
        }


        /**
         * 适配低版本网络检查
         * @param context
         */
        fun getNetworkIsAvailableForOld(context: Context): Boolean {
            var con = context.getSystemService(Context.CONNECTIVITY_SERVICE)
            var network = (con as ConnectivityManager).activeNetworkInfo
            if (network != null) {
                return network.isAvailable
            }
            return false
        }
    }

}