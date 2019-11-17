package com.kailaisi.eshopdatalinkservice.model.qo

class PageQO<T>(var pageNum: Int = 0, var pageSize: Int = 10) {
    var orderBy: String? = null
    var condition: T? = null
}
