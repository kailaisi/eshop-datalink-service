package com.kailaisi.eshopdatalinkservice.config.mapper

import tk.mybatis.mapper.common.Mapper
import tk.mybatis.mapper.common.MySqlMapper

/**
 *描述：自定义使用的mapper
 *
 *<p/>作者：wu
 *<br/>创建时间：2019/11/13 17:21
 */
interface MyMapper<T> : Mapper<T>, MySqlMapper<T>{
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}