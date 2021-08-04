package com.lazyxu.lazystudy

import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference
import kotlin.reflect.KProperty

class Weak<T : Any>(initializer: () -> T?) {
    var weakReference = WeakReference(initializer())

    constructor() : this({
        null
    })

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return weakReference.get()!!
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        weakReference = WeakReference(value)
    }

}

/**
 * 仅共Activity使用处理bugly报错 Activity has been destroyed
 */
class WeakRef<T : Any>(initializer: () -> T?) {
    private var weakReference = WeakReference(initializer())

    constructor() : this({
        null
    })

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        return if (weakReference.get() == null || (weakReference.get() as AppCompatActivity).isDestroyed)
            null
        else {
            weakReference.get()
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        weakReference = WeakReference(value)
    }

}

