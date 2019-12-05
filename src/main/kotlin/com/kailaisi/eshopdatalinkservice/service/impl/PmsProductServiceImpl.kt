package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.mgb.model.PmsProduct
import com.kailaisi.eshopdatalinkservice.service.PmsProductService
import com.kailaisi.eshopdatalinkservice.service.commonservice.MySqlCrudServiceImpl

class PmsProductServiceImpl : MySqlCrudServiceImpl<PmsProduct, Long>(), PmsProductService