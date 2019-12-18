package com.yingjia.mobile.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


/**
 * Created by 3ompact on 2019/12/18 11:22
 *
 */
class Rom {
    companion object {
        fun isIntentAvailable(intent: Intent, context: Context): Boolean {
            return (intent != null) && (context.packageManager.queryIntentActivities(
                intent,
                PackageManager.MATCH_DEFAULT_ONLY
            ).size > 0)
        }


        fun getProp(name:String): String? {
            var input: BufferedReader? = null
            try{
                var p:Process = Runtime.getRuntime().exec("getprop " + name)
                input = BufferedReader(InputStreamReader(p.inputStream),1024)
                var line :String = input.readLine()
                input.close()
                return line
            }catch(ex:IOException){
                return null
            }finally {
                if(input != null){
                    try {
                        input.close()
                    }catch (ex:IOException){
                        ex.printStackTrace()
                    }
                }
            }

        }
    }
}