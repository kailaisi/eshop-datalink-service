package com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResultCode

class ParameterInvalidException : BusinessException {

    constructor() : super()

    constructor(data: Any) : super()

    constructor(resultCode: ResultCode) : super(resultCode)

    constructor(resultCode: ResultCode, data: Any) : super(resultCode, data)

    constructor(msg: String) : super(msg)

    constructor(formatMsg: String, vararg objects: Any) : super(formatMsg, *objects)
}