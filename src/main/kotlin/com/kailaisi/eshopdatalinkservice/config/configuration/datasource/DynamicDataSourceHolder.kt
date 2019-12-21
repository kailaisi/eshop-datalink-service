package com.kailaisi.eshopdatalinkservice.config.configuration.datasource

import com.kailaisi.eshopdatalinkservice.util.logger

object  DynamicDataSourceHolder {
    val log = logger(this)
    val contextHolder=ThreadLocal<String?>()
    val DB_MASTER="master"
    val DB_SLAVE="slave"
    fun getDbType():String{
        return contextHolder.get()?:"master"
    }
    fun setDbType(str:String){
        log.info("所使用的数据源是：${str}")
        contextHolder.set(str)
    }
    fun clear(){
        contextHolder.remove()
    }
}