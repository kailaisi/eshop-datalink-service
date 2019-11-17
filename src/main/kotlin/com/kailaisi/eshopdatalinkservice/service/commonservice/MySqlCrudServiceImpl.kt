package com.kailaisi.eshopdatalinkservice.service.commonservice

import com.github.pagehelper.PageHelper
import com.kailaisi.eshopdatalinkservice.config.mapper.CrudMapper
import com.kailaisi.eshopdatalinkservice.dto.CommonPage
import com.kailaisi.eshopdatalinkservice.mgb.BaseModel
import com.kailaisi.eshopdatalinkservice.model.qo.PageQO
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.util.Assert
import tk.mybatis.mapper.entity.Condition
import tk.mybatis.mapper.entity.Example
import java.lang.reflect.ParameterizedType
import java.util.*

/**
 *描述：通用Service的实现
 *<p/>作者：wu
 *<br/>创建时间：2019/11/14 16:39
 */
open class MySqlCrudServiceImpl<E : BaseModel<PK>, PK> : CrudService<E, PK> {

    @Autowired
    lateinit var crudMapper: CrudMapper<E>

    private val modeType: Class<E>

    init {
        val parameterizedType = javaClass.genericSuperclass as ParameterizedType
        modeType = parameterizedType.actualTypeArguments[0] as Class<E>
    }

    override fun selectByPk(pk: PK): E? {
        Assert.notNull(pk, "pk can not be null")
        return crudMapper.selectByPrimaryKey(pk)
    }

    override fun selectByPks(list: Iterable<PK>): List<E> {
        Assert.notNull(list, "pks can not be null")
        val pksStr = list.joinToString(separator = ",", transform = { it.toString() })
        return if (pksStr.isBlank()) {
            emptyList()
        } else {
            crudMapper.selectByIds(pksStr)
        }
    }

    override fun selectAll(): List<E> {
        return crudMapper.selectAll()
    }

    override fun selectPage(pageQO: PageQO<*>): CommonPage<*> {
        var page = PageHelper.startPage<E>(pageQO.pageNum, pageQO.pageSize)
        try {
            var condition = pageQO.condition
            when (condition) {
                null -> crudMapper.selectAll()
                is Condition -> crudMapper.selectByCondition(condition)
                is Example -> crudMapper.selectByExample(condition)
                else -> {
                    if (modeType.isInstance(condition)) {
                        crudMapper.select(condition as E)
                    } else {
                        try {
                            val e = modeType.newInstance()
                            BeanUtils.copyProperties(condition, e)
                            crudMapper.select(e)
                        } catch (e: Exception) {
                            throw RuntimeException("poType.newInstance occurs InstantiationException or IllegalAccessException", e)
                        }
                    }
                }
            }
        } finally {
            page.close()
        }
        return CommonPage.build(page)
    }

    override fun insert(e: E): PK {
        Assert.notNull(e, "数据不能为空")
        if (e.getCreateTime() == null) {
            val date = Date()
            e.setUpdateTime(date)
            e.setCreateTime(date)
        }
        crudMapper.insert(e)
        return e.getId()
    }

    override fun updateByPk(pk: PK, e: E): Int {
        Assert.notNull(pk, "主键不能为空")
        Assert.notNull(e, "数据不能为空")
        e.setId(pk)
        if (e.getUpdateTime() == null) {
            e.setUpdateTime(Date())
        }
        return crudMapper.updateByPrimaryKey(e)
    }

    override fun updateByPkSelective(pk: PK, e: E): Int {
        Assert.notNull(pk, "主键不能为空")
        Assert.notNull(e, "数据不能为空")
        e.setId(pk)
        if (e.getUpdateTime() == null) {
            e.setUpdateTime(Date())
        }
        return crudMapper.updateByPrimaryKeySelective(e)
    }

    override fun saveOrUpdate(e: E): PK {
        Assert.notNull(e, "数据不能为空")
        if (e.getId() != null && null != selectByPk(e.getId())) {
            updateByPk(e.getId(), e)
        } else {
            insert(e)
        }
        return e.getId()
    }

    override fun deleteByPk(pk: PK): Int {
        Assert.notNull(pk, "主键不能为空")
        return crudMapper.deleteByPrimaryKey(pk)
    }

    override fun deleteByPks(list: Iterable<PK>): Int {
        Assert.notNull(list, "pks can not be null")
        val pksStr = list.joinToString(separator = ",", transform = { it.toString() })
        return if (pksStr.isBlank()) {
            0
        } else {
            crudMapper.deleteByIds(pksStr)
        }
    }
}