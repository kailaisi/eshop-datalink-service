package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "pms_feight_template")
public class PmsFeightTemplate extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("")
    private String name;

    /**
     * 计费类型:0->按重量；1->按件数
     */
    @Column(name = "charge_type")
    @ApiModelProperty("计费类型:0->按重量；1->按件数")
    private Integer chargeType;

    /**
     * 首重kg
     */
    @Column(name = "first_weight")
    @ApiModelProperty("首重kg")
    private BigDecimal firstWeight;

    /**
     * 首费（元）
     */
    @Column(name = "first_fee")
    @ApiModelProperty("首费（元）")
    private BigDecimal firstFee;

    @Column(name = "continue_weight")
    @ApiModelProperty("")
    private BigDecimal continueWeight;

    @Column(name = "continme_fee")
    @ApiModelProperty("")
    private BigDecimal continmeFee;

    /**
     * 目的地（省、市）
     */
    @ApiModelProperty("目的地（省、市）")
    private String dest;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取计费类型:0->按重量；1->按件数
     *
     * @return charge_type - 计费类型:0->按重量；1->按件数
     */
    public Integer getChargeType() {
        return chargeType;
    }

    /**
     * 设置计费类型:0->按重量；1->按件数
     *
     * @param chargeType 计费类型:0->按重量；1->按件数
     */
    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    /**
     * 获取首重kg
     *
     * @return first_weight - 首重kg
     */
    public BigDecimal getFirstWeight() {
        return firstWeight;
    }

    /**
     * 设置首重kg
     *
     * @param firstWeight 首重kg
     */
    public void setFirstWeight(BigDecimal firstWeight) {
        this.firstWeight = firstWeight;
    }

    /**
     * 获取首费（元）
     *
     * @return first_fee - 首费（元）
     */
    public BigDecimal getFirstFee() {
        return firstFee;
    }

    /**
     * 设置首费（元）
     *
     * @param firstFee 首费（元）
     */
    public void setFirstFee(BigDecimal firstFee) {
        this.firstFee = firstFee;
    }

    /**
     * @return continue_weight
     */
    public BigDecimal getContinueWeight() {
        return continueWeight;
    }

    /**
     * @param continueWeight
     */
    public void setContinueWeight(BigDecimal continueWeight) {
        this.continueWeight = continueWeight;
    }

    /**
     * @return continme_fee
     */
    public BigDecimal getContinmeFee() {
        return continmeFee;
    }

    /**
     * @param continmeFee
     */
    public void setContinmeFee(BigDecimal continmeFee) {
        this.continmeFee = continmeFee;
    }

    /**
     * 获取目的地（省、市）
     *
     * @return dest - 目的地（省、市）
     */
    public String getDest() {
        return dest;
    }

    /**
     * 设置目的地（省、市）
     *
     * @param dest 目的地（省、市）
     */
    public void setDest(String dest) {
        this.dest = dest;
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