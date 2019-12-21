package com.kailaisi.eshopdatalinkservice.config.configuration.datasource

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

/**
 *描述：spring提供了AbstractRoutingDataSource，提供了动态选择数据源的功能，替换原有的单一数据源后，即可实现读写分离:
 *<p/>作者：wu
 *<br/>创建时间：2019/12/21 22:38
 */
class DynamicDataSource : AbstractRoutingDataSource() {

    override fun determineCurrentLookupKey(): Any? {
        return DynamicDataSourceHolder.getDbType()
    }
}
