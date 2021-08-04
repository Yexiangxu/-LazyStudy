package com.lazyxu.network.base

data class BaseEntity<T>(
    var data: T? = null,
    var code: Int? = 0,
    var err: String? = null
)