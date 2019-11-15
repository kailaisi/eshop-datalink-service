package com.kailaisi.eshopdatalinkservice.service.commonservice

import com.kailaisi.eshopdatalinkservice.dto.CommonPage

/**
 *描述：通用Service的实现
 *<p/>作者：wu
 *<br/>创建时间：2019/11/14 16:39
 */
class MySqlCrudServiceImpl<E,PK>:CrudService<E,PK> {
    override fun selectByPk(pk: PK): E? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectByPks(list: List<PK>): List<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectAll(): List<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectPage(): CommonPage<*> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insert(e: E): PK {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateByPk(pk: PK, e: E): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateByPkSelective(pk: PK, e: E): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveOrUpdate(e: E): PK {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteByPk(pk: PK): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteByPks(list: List<PK>): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}