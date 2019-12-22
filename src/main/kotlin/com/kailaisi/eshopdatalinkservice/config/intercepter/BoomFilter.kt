package com.kailaisi.eshopdatalinkservice.config.intercepter

import com.kailaisi.eshopdatalinkservice.service.RedisService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/12/22 15:00
 */
class BoomFilter(var correctRatio: CorrectRatio, var n: Long) {
    private var hashFunction: Array<HashFunction>
    private var seed: IntArray
    private var cap: Long
    @Autowired
    lateinit var redisService: RedisService
    private val bitMapPrefix = "bitMapPrefix"

    init {
        this.cap = correctRatio.seed.size * n
        this.seed = correctRatio.seed
        hashFunction = Array(seed.size) { HashFunction(1, 1) }
        seed.forEachIndexed { index, i ->
            this.hashFunction[index] = HashFunction(i, this.cap)
        }
    }

    fun add(value: String) {
        seed.forEachIndexed { index, i ->
            redisService.setBit(bitMapPrefix, hashFunction[index].hash(value), true)
        }
    }

    fun contains(value: String): Boolean {
        var flag = true
        seed.forEachIndexed { index, i ->
            flag = flag && redisService.getBit(bitMapPrefix, hashFunction[i].hash(value))
            if (!flag) {
                return false
            }
        }
        return flag
    }


}

class HashFunction(private val seed: Int, private val cap: Long) {
    fun hash(value: String): Long {
        var result = 0
        for (element in value) {
            result = result * seed + element.toInt()
        }
        //求余数 防止redis中bitMap无限膨胀  类似循环队列 可以防止系统OOM
        return (result and (cap - 1).toInt()).toLong()
    }

}

enum class CorrectRatio(var seed: IntArray) {
    /**
     * 32位代表一个数
     */
    HIGH(intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131));

}
