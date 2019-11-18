package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.mgb.model.PmsBrand
import com.kailaisi.eshopdatalinkservice.service.PmsBrandService
import com.kailaisi.eshopdatalinkservice.service.commonservice.MySqlCrudServiceImpl
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/14 14:16
 */
@Service
class PmsBrandServiceImpl : MySqlCrudServiceImpl<PmsBrand, Long>(), PmsBrandService {
}