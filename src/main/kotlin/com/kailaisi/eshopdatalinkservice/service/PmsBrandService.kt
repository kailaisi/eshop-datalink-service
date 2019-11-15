package com.kailaisi.eshopdatalinkservice.service

import com.kailaisi.eshopdatalinkservice.mgb.model.PmsBrand

/**
 *描述：品牌服务
 *<p/>作者：wu
 *<br/>创建时间：2019/11/14 14:16
 */
interface PmsBrandService {
    /**
     * 返回所有的品牌信息
     */
    fun listAllBrand(): List<PmsBrand>

    fun creatBrand(pmsBrand: PmsBrand): Int

    fun updateBrand(id: Long, pmsBrand: PmsBrand): Int

    fun deleteBrand(id: Long): Int

    fun listBrand(keyword: String, pageNum: Int, pageSize: Int): List<PmsBrand>

}
