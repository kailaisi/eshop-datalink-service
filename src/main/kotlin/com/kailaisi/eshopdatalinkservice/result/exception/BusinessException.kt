package com.kailaisi.eshopdatalinkservice.result.exception

import com.kailaisi.eshopdatalinkservice.model.ResultCode

open class BusinessException() : RuntimeException() {

    var code: String? = null

    override var message: String? = null

    var resultCode: ResultCode? = null

    var data: Any? = null

    init{
        val exceptionEnum = BusinessExceptionEnum.getByEClass(this.javaClass)
        if (exceptionEnum != null) {
            resultCode = exceptionEnum.resultCode
            code = exceptionEnum.resultCode.code.toString()
            message = exceptionEnum.resultCode.msg
        }
    }

    constructor(message: String) : this() {
        this.message = message
    }

    constructor(format: String, vararg objects: Any) : this() {
        TODO()
    }

    constructor(resultCode: ResultCode, data: Any) : this(resultCode) {
        this.data = data
    }

    constructor(resultCode: ResultCode) : this() {
        this.resultCode = resultCode
        this.code = resultCode.code.toString()
        this.message = resultCode.msg
    }
}