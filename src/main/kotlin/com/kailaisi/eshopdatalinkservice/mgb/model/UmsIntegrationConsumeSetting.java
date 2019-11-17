package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "ums_integration_consume_setting")
public class UmsIntegrationConsumeSetting extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 每一元需要抵扣的积分数量
     */
    @Column(name = "deduction_per_amount")
    @ApiModelProperty("每一元需要抵扣的积分数量")
    private Integer deductionPerAmount;

    /**
     * 每笔订单最高抵用百分比
     */
    @Column(name = "max_percent_per_order")
    @ApiModelProperty("每笔订单最高抵用百分比")
    private Integer maxPercentPerOrder;

    /**
     * 每次使用积分最小单位100
     */
    @Column(name = "use_unit")
    @ApiModelProperty("每次使用积分最小单位100")
    private Integer useUnit;

    /**
     * 是否可以和优惠券同用；0->不可以；1->可以
     */
    @Column(name = "coupon_status")
    @ApiModelProperty("是否可以和优惠券同用；0->不可以；1->可以")
    private Integer couponStatus;

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
     * 获取每一元需要抵扣的积分数量
     *
     * @return deduction_per_amount - 每一元需要抵扣的积分数量
     */
    public Integer getDeductionPerAmount() {
        return deductionPerAmount;
    }

    /**
     * 设置每一元需要抵扣的积分数量
     *
     * @param deductionPerAmount 每一元需要抵扣的积分数量
     */
    public void setDeductionPerAmount(Integer deductionPerAmount) {
        this.deductionPerAmount = deductionPerAmount;
    }

    /**
     * 获取每笔订单最高抵用百分比
     *
     * @return max_percent_per_order - 每笔订单最高抵用百分比
     */
    public Integer getMaxPercentPerOrder() {
        return maxPercentPerOrder;
    }

    /**
     * 设置每笔订单最高抵用百分比
     *
     * @param maxPercentPerOrder 每笔订单最高抵用百分比
     */
    public void setMaxPercentPerOrder(Integer maxPercentPerOrder) {
        this.maxPercentPerOrder = maxPercentPerOrder;
    }

    /**
     * 获取每次使用积分最小单位100
     *
     * @return use_unit - 每次使用积分最小单位100
     */
    public Integer getUseUnit() {
        return useUnit;
    }

    /**
     * 设置每次使用积分最小单位100
     *
     * @param useUnit 每次使用积分最小单位100
     */
    public void setUseUnit(Integer useUnit) {
        this.useUnit = useUnit;
    }

    /**
     * 获取是否可以和优惠券同用；0->不可以；1->可以
     *
     * @return coupon_status - 是否可以和优惠券同用；0->不可以；1->可以
     */
    public Integer getCouponStatus() {
        return couponStatus;
    }

    /**
     * 设置是否可以和优惠券同用；0->不可以；1->可以
     *
     * @param couponStatus 是否可以和优惠券同用；0->不可以；1->可以
     */
    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
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