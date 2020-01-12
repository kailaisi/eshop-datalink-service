package com.kailaisi.eshopdatalinkservice.config.configuration.datasource

import com.kailaisi.eshopdatalinkservice.util.logger

/**
 *描述：静态类，里面持有了数据源信息
 *<p/>作者：wu
 *<br/>创建时间：2020/1/2 22:52
 */
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