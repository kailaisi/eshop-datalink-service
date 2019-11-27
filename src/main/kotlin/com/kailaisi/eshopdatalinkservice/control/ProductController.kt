package com.kailaisi.eshopdatalinkservice.control

import com.alibaba.fastjson.JSONObject
import com.kailaisi.eshopdatalinkservice.config.intercepter.LoginAuth
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.service.CacheService
import com.kailaisi.eshopdatalinkservice.service.EshopProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import redis.clients.jedis.JedisPool

/**
 *描述：本地缓存->主机群缓存->服务接口
 *<p/>作者：wu
 *<br/>创建时间：2019/5/24 14:33
 */
@ResponseResult
@RestController
@LoginAuth
class ProductController {
    @Autowired
    lateinit var productService: EshopProductService
    @Autowired
    lateinit var cacheService: CacheService
    @Autowired
    lateinit var jedis: JedisPool

    @RequestMapping("/product")
    fun getProduct(id: Long): String? {
        print("直连服务获取到请求$id")
        var resource = jedis.resource
        var info: String?
        info = cacheService.getProductInfo(id)
        if (info.isNullOrBlank()) {
            info = resource.get("dim_product_$id")
            if (info.isNullOrBlank()) {
                //从服务接口获取
                info = productService?.findProductById(id)
                if (!info.isNullOrEmpty()) {
                    var productJSONObject = JSONObject.parseObject(info)
                    var property = productService.findProductPropertyByProductId(id)
                    if (!property.isNullOrEmpty()) {
                        productJSONObject["product_property"] = JSONObject.parseArray(property)
                    }
                    var specification = productService.findProductSpecificationByProductId(id)
                    if (!specification.isNullOrEmpty()) {
                        productJSONObject["product_specification"] = JSONObject.parseArray(specification)
                    }
                    info = productJSONObject.toJSONString()
                    resource.set("dim_product_$id", info)
                    cacheService.putProductInfo(id, info)
                }
            }
        }
        resource.close()
        return info
    }
}