package com.kailaisi.eshopdatalinkservice.config.mapper

import tk.mybatis.mapper.common.Mapper
import tk.mybatis.mapper.common.MySqlMapper
import tk.mybatis.mapper.common.condition.SelectByConditionMapper
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper
import tk.mybatis.mapper.common.ids.SelectByIdsMapper

/**
 *描述：自定义使用的增删改查mapper
 *
 *<p/>作者：wu
 *<br/>创建时间：2019/11/13 17:21
 */
interface CrudMapper<T> : Mapper<T>, MySqlMapper<T>,SelectByIdsMapper<T>,DeleteByIdsMapper<T>,SelectByConditionMapper<T>{
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}