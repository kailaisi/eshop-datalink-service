package com.kailaisi.eshopdatalinkservice.util

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ParameterInvalidItem
import org.springframework.util.CollectionUtils
import org.springframework.validation.BindingResult
import javax.validation.ConstraintViolation


/**
 *描述：参数无效的校验辅助类，可以批量校验字段是否满足要求
 *<p/>作者：wu
 *<br/>创建时间：2019/11/7 16:08
 */
object ParameterInvalidItemHelper {

    fun <T> convertCVSetObjectToParameterInvalidItemList(cvset: Set<ConstraintViolation<T>>): List<ParameterInvalidItem>? {
        if (CollectionUtils.isEmpty(cvset)) {
            return null
        }
        val parameterInvalidItemList = mutableListOf<ParameterInvalidItem>()
        for (cv in cvset) {
            val parameterInvalidItem = ParameterInvalidItem()
            val propertyPath = cv.propertyPath.toString()
            if (propertyPath.indexOf(".") != -1) {
                val propertyPathArr = propertyPath.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                parameterInvalidItem.fieldName = propertyPathArr[propertyPathArr.size - 1]
            } else {
                parameterInvalidItem.fieldName = propertyPath
            }
            parameterInvalidItem.message = cv.message
            parameterInvalidItemList.add(parameterInvalidItem)
        }

        return parameterInvalidItemList
    }

    fun convertCVSetToParameterInvalidItemList(cvset: Set<ConstraintViolation<*>>): List<ParameterInvalidItem>? {
        if (CollectionUtils.isEmpty(cvset)) {
            return null
        }

        val parameterInvalidItemList = mutableListOf<ParameterInvalidItem>()
        for (cv in cvset) {
            val parameterInvalidItem = ParameterInvalidItem()
            val propertyPath = cv.propertyPath.toString()
            if (propertyPath.indexOf(".") != -1) {
                val propertyPathArr = propertyPath.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                parameterInvalidItem.fieldName = propertyPathArr[propertyPathArr.size - 1]
            } else {
                parameterInvalidItem.fieldName = propertyPath
            }
            parameterInvalidItem.message = cv.message
            parameterInvalidItemList.add(parameterInvalidItem)
        }

        return parameterInvalidItemList
    }

    fun convertBindingResultToMapParameterInvalidItemList(bindingResult: BindingResult?): List<ParameterInvalidItem>? {
        if (bindingResult == null) {
            return null
        }

        val parameterInvalidItemList = mutableListOf<ParameterInvalidItem>()

        val fieldErrorList = bindingResult.fieldErrors
        for (fieldError in fieldErrorList) {
            val parameterInvalidItem = ParameterInvalidItem()
            parameterInvalidItem.fieldName = fieldError.field
            parameterInvalidItem.message = fieldError.defaultMessage
            parameterInvalidItemList.add(parameterInvalidItem)
        }

        return parameterInvalidItemList
    }

}
