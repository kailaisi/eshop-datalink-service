package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "oms_order_setting")
public class OmsOrderSetting extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    @Column(name = "flash_order_overtime")
    @ApiModelProperty("秒杀订单超时关闭时间(分)")
    private Integer flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    @Column(name = "normal_order_overtime")
    @ApiModelProperty("正常订单超时时间(分)")
    private Integer normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    @Column(name = "confirm_overtime")
    @ApiModelProperty("发货后自动确认收货时间（天）")
    private Integer confirmOvertime;

    /**
     * 自动完成交易时间，不能申请售后（天）
     */
    @Column(name = "finish_overtime")
    @ApiModelProperty("自动完成交易时间，不能申请售后（天）")
    private Integer finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    @Column(name = "comment_overtime")
    @ApiModelProperty("订单完成后自动好评时间（天）")
    private Integer commentOvertime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取秒杀订单超时关闭时间(分)
     *
     * @return flash_order_overtime - 秒杀订单超时关闭时间(分)
     */
    public Integer getFlashOrderOvertime() {
        return flashOrderOvertime;
    }

    /**
     * 设置秒杀订单超时关闭时间(分)
     *
     * @param flashOrderOvertime 秒杀订单超时关闭时间(分)
     */
    public void setFlashOrderOvertime(Integer flashOrderOvertime) {
        this.flashOrderOvertime = flashOrderOvertime;
    }

    /**
     * 获取正常订单超时时间(分)
     *
     * @return normal_order_overtime - 正常订单超时时间(分)
     */
    public Integer getNormalOrderOvertime() {
        return normalOrderOvertime;
    }

    /**
     * 设置正常订单超时时间(分)
     *
     * @param normalOrderOvertime 正常订单超时时间(分)
     */
    public void setNormalOrderOvertime(Integer normalOrderOvertime) {
        this.normalOrderOvertime = normalOrderOvertime;
    }

    /**
     * 获取发货后自动确认收货时间（天）
     *
     * @return confirm_overtime - 发货后自动确认收货时间（天）
     */
    public Integer getConfirmOvertime() {
        return confirmOvertime;
    }

    /**
     * 设置发货后自动确认收货时间（天）
     *
     * @param confirmOvertime 发货后自动确认收货时间（天）
     */
    public void setConfirmOvertime(Integer confirmOvertime) {
        this.confirmOvertime = confirmOvertime;
    }

    /**
     * 获取自动完成交易时间，不能申请售后（天）
     *
     * @return finish_overtime - 自动完成交易时间，不能申请售后（天）
     */
    public Integer getFinishOvertime() {
        return finishOvertime;
    }

    /**
     * 设置自动完成交易时间，不能申请售后（天）
     *
     * @param finishOvertime 自动完成交易时间，不能申请售后（天）
     */
    public void setFinishOvertime(Integer finishOvertime) {
        this.finishOvertime = finishOvertime;
    }

    /**
     * 获取订单完成后自动好评时间（天）
     *
     * @return comment_overtime - 订单完成后自动好评时间（天）
     */
    public Integer getCommentOvertime() {
        return commentOvertime;
    }

    /**
     * 设置订单完成后自动好评时间（天）
     *
     * @param commentOvertime 订单完成后自动好评时间（天）
     */
    public void setCommentOvertime(Integer commentOvertime) {
        this.commentOvertime = commentOvertime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}