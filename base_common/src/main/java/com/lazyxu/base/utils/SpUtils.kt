package com.lazyxu.base.utils

import android.content.Context
import com.tencent.mmkv.MMKV

/**
 * MMKV使用封装
 */
object SpUtils {

    /**
     * 初始化
     */
    fun initMMKV(context: Context): String? = MMKV.initialize(context)

    /**
     * 增、改
     * 根据value类型自动匹配需要执行的方法
     */
    fun put(key: String, value: Any) =
        when (value) {
            is Int -> MMKV.defaultMMKV()?.encode(key, value)
            is Long -> MMKV.defaultMMKV()?.encode(key, value)
            is Float -> MMKV.defaultMMKV()?.encode(key, value)
            is Double -> MMKV.defaultMMKV()?.encode(key, value)
            is String -> MMKV.defaultMMKV()?.encode(key, value)
            is Boolean -> MMKV.defaultMMKV()?.encode(key, value)
            else -> false
        }

    /**
     * 查
     */
    fun getString(key: String, defValue: String): String? =
        MMKV.defaultMMKV()?.decodeString(key, defValue)

    fun getInt(key: String, defValue: Int): Int? = MMKV.defaultMMKV()?.decodeInt(key, defValue)

    fun getLong(key: String, defValue: Long): Long? = MMKV.defaultMMKV()?.decodeLong(key, defValue)

    fun getDouble(key: String, defValue: Double): Double? =
        MMKV.defaultMMKV()?.decodeDouble(key, defValue)

    fun getFloat(key: String, defValue: Float): Float? =
        MMKV.defaultMMKV()?.decodeFloat(key, defValue)

    fun getBoolean(key: String, defValue: Boolean): Boolean? =
        MMKV.defaultMMKV()?.decodeBool(key, defValue)

    fun contains(key: String): Boolean? = MMKV.defaultMMKV()?.contains(key)


    /**
     * 删
     */
    fun remove(key: String) = MMKV.defaultMMKV()?.removeValueForKey(key)
    fun remove(vararg key: String) = MMKV.defaultMMKV()?.removeValuesForKeys(key)
    fun clearAll() = MMKV.defaultMMKV()?.clearAll()

}