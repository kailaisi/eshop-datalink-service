package com.kailaisi.eshopdatalinkservice.service.impl

import com.github.pagehelper.PageHelper
import com.kailaisi.eshopdatalinkservice.mgb.mapper.PmsBrandMapper
import com.kailaisi.eshopdatalinkservice.mgb.model.PmsBrand
import com.kailaisi.eshopdatalinkservice.service.PmsBrandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/14 14:16
 */
@Service
class PmsBrandServiceImpl : PmsBrandService {
    @Autowired
    lateinit var pmsBrandMapper: PmsBrandMapper
    override fun listBrand(keyword: String, pageNum: Int, pageSize: Int): List<PmsBrand> {
        var page = PageHelper.startPage<PmsBrand>(pageNum, pageSize)
        var example = pmsBrandMapper.selectByExample(PmsBrand())
        return example
    }



    override fun listAllBrand(): List<PmsBrand> {
        return pmsBrandMapper.selectAll()
    }

    override fun creatBrand(pmsBrand: PmsBrand): Int {
     return   pmsBrandMapper.insert(pmsBrand)
    }

    override fun updateBrand(id: Long, pmsBrand: PmsBrand): Int {
        pmsBrand.setId(id)
        return  pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand)
    }

    override fun deleteBrand(id: Long): Int {
        return pmsBrandMapper.deleteByPrimaryKey(id)
    }
}