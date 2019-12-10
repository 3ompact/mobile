package com.yingjia.mobile.utils

import java.io.File

/**
 * Created by 3ompact on 2019/10/29 14:01
 *
 */
class FileUtil {

    /**
     * 根据文件地址获取文件
     */
    public fun getFile(filePath : String ): File {
        return File(filePath)
    }

    /**
     * 获取绝对路径
     */
    public fun getFilePath(file : File): String {
        return file.absolutePath
    }
}