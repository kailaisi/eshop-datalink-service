package com.kailaisi.eshopdatalinkservice.exception

import com.kailaisi.eshopdatalinkservice.data.ResultCode

class ParameterInvalidException : BusinessException {

    constructor() : super()

    constructor(data: Any) : super()

    constructor(resultCode: ResultCode) : super(resultCode)

    constructor(resultCode: ResultCode, data: Any) : super(resultCode, data)

    constructor(msg: String) : super(msg)

    constructor(formatMsg: String, vararg objects: Any) : super(formatMsg, *objects)
}