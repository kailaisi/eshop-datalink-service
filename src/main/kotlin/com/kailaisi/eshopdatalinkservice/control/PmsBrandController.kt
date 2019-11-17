package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.dto.CommonPage
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.mgb.model.PmsBrand
import com.kailaisi.eshopdatalinkservice.service.PmsBrandService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


/**
 *描述：品牌管理
 *<p/>作者：wu
 *<br/>创建时间：2019/11/7 11:31
 */
@ResponseResult
@RestController
@Api(tags = ["PmsBrandController"], description = "商品的品牌管理")
@RequestMapping("/brand")
class PmsBrandController {
    @Autowired
    lateinit var mService: PmsBrandService

    @ApiOperation("获取所有的品牌列表信息")
    @GetMapping("listAll")
    fun getBrandList(): List<PmsBrand> {
        return mService.listAllBrand()
    }

    @ApiOperation("生成品牌信息")
    @PostMapping("/create")
    fun createBrand(@Validated @RequestBody pmsBrand: PmsBrand): PmsBrand {
        val count = mService.creatBrand(pmsBrand)
        return when (count) {
            1 -> pmsBrand
            else -> throw BusinessException("createBrand failed:{${pmsBrand}}")
        }
    }

    @ApiOperation("更新指定ID的品牌信息")
    @PostMapping("/update/{id}")
    fun update(@PathVariable("id") id: Long, @Validated @RequestBody pmsBrand: PmsBrand): String {
        val count = mService.updateBrand(id, pmsBrand)
        return when (count) {
            1 -> "更新id=${id}数据成功"
            else -> throw BusinessException("updateBrand failed:{${pmsBrand}}")
        }
    }

    @ApiOperation("删除指定Id的品牌信息")
    @GetMapping("/delete/{id}")
    fun delete(@Validated @PathVariable("id") id: Long): String {
        val count = mService.deleteBrand(id)
        return when (count) {
            1 -> "删除数据成功"
            else -> throw BusinessException("deleteBrand failed :id={$id}")
        }
    }

    @ApiOperation("分页查询品牌列表")
    @GetMapping(value = ["/list"])
    @ResponseBody
    fun getList(@RequestParam(value = "keyword", required = false) keyword: String,
                @RequestParam(value = "pageNum", defaultValue = "1") pageNum: Int,
                @RequestParam(value = "pageSize", defaultValue = "5") pageSize: Int): CommonPage<PmsBrand> {
        val brandList = mService.listBrand(keyword, pageNum, pageSize)
        return CommonPage.restPage(brandList)
    }

}