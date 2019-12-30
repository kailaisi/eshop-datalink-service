package com.kailaisi.eshopdatalinkservice.util

import org.I0Itec.zkclient.IZkDataListener
import org.I0Itec.zkclient.ZkClient
import java.util.concurrent.CountDownLatch

/**
 *描述：基于Zookeeper实现的分布式锁
 *<p/>作者：wu
 *<br/>创建时间：2019/12/30 23:41
 */
abstract class ZkAbstractLock {
    val CONNECTION = "127.0.0.1:2181"
    val zkClient = ZkClient(CONNECTION)
    val PATH = "/zkLock"
    var countDownLatch: CountDownLatch? = null

    fun getLock(): Boolean {
        try {
            var locked = false
            locked = tryLock()
            if (locked) {
                return true
            }
            while (!locked) {
                await()
                if (checkLocked()) {
                    locked = true
                }
            }
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            unlock()
        }
        return false
    }

    private fun checkLocked(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun unlock() {

    }

    /**
     * 等待，创建一个zk的节点监听器，如果节点已经删除了，那么
     */
    fun await() {
        val value = object : IZkDataListener {
            override fun handleDataDeleted(p0: String?) {
            }

            override fun handleDataChange(p0: String?, p1: Any?) {
                countDownLatch?.countDown()
            }
        }
        zkClient.subscribeDataChanges(PATH, value)
        if (zkClient.exists(PATH)) {
            countDownLatch= CountDownLatch(1)
            try {
                countDownLatch!!.await()
            } catch (e: Exception) {
            }
        }
        zkClient.unsubscribeDataChanges(PATH,value)
    }

    /**
     * 尝试获取锁，也就是生成一个节点
     */
    fun tryLock(): Boolean {
        try {
            zkClient.createEphemeral(PATH)
            return true
        } catch (e: Exception) {
            return false
        }
    }
}