package com.kailaisi.eshopdatalinkservice.result.exception

import com.kailaisi.eshopdatalinkservice.model.ResultCode

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 22:42
 */
class DataConflictException:BusinessException {
    constructor() : super()

    constructor(data: Any) : super()

    constructor(resultCode: ResultCode) : super(resultCode)

    constructor(resultCode: ResultCode, data: Any) : super(resultCode, data)

    constructor(msg: String) : super(msg)

    constructor(formatMsg: String, vararg objects: Any) : super(formatMsg, *objects)
}