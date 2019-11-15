package com.kailaisi.eshopdatalinkservice.service.commonservice

/**
 *描述：通用的增删改查Service
 *<p/>作者：wu
 *<br/>创建时间：2019/11/14 15:39
 */
interface CrudService<E, PK> : BaseSelectService<E, PK>, BaseInsertService<E, PK>, BaseUpdateService<E, PK>, BaseDeleteService<PK>