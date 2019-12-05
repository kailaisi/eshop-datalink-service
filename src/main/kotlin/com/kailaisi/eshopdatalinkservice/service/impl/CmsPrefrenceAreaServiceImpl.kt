package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.mgb.model.CmsPrefrenceArea
import com.kailaisi.eshopdatalinkservice.service.CmsPrefrenceAreaService
import com.kailaisi.eshopdatalinkservice.service.commonservice.MySqlCrudServiceImpl
import org.springframework.stereotype.Service

/**
 * 描述：
 *
 * 作者：wu
 * <br></br>创建时间：2019/12/5 16:24
 */
@Service
class CmsPrefrenceAreaServiceImpl : MySqlCrudServiceImpl<CmsPrefrenceArea, Long>(), CmsPrefrenceAreaService