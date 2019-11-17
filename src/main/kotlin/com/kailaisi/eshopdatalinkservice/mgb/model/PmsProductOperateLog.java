package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "pms_product_operate_log")
public class PmsProductOperateLog extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "product_id")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "price_old")
    @ApiModelProperty("")
    private BigDecimal priceOld;

    @Column(name = "price_new")
    @ApiModelProperty("")
    private BigDecimal priceNew;

    @Column(name = "sale_price_old")
    @ApiModelProperty("")
    private BigDecimal salePriceOld;

    @Column(name = "sale_price_new")
    @ApiModelProperty("")
    private BigDecimal salePriceNew;

    /**
     * 赠送的积分
     */
    @Column(name = "gift_point_old")
    @ApiModelProperty("赠送的积分")
    private Integer giftPointOld;

    @Column(name = "gift_point_new")
    @ApiModelProperty("")
    private Integer giftPointNew;

    @Column(name = "use_point_limit_old")
    @ApiModelProperty("")
    private Integer usePointLimitOld;

    @Column(name = "use_point_limit_new")
    @ApiModelProperty("")
    private Integer usePointLimitNew;

    /**
     * 操作人
     */
    @Column(name = "operate_man")
    @ApiModelProperty("操作人")
    private String operateMan;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;

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
     * @return product_id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return price_old
     */
    public BigDecimal getPriceOld() {
        return priceOld;
    }

    /**
     * @param priceOld
     */
    public void setPriceOld(BigDecimal priceOld) {
        this.priceOld = priceOld;
    }

    /**
     * @return price_new
     */
    public BigDecimal getPriceNew() {
        return priceNew;
    }

    /**
     * @param priceNew
     */
    public void setPriceNew(BigDecimal priceNew) {
        this.priceNew = priceNew;
    }

    /**
     * @return sale_price_old
     */
    public BigDecimal getSalePriceOld() {
        return salePriceOld;
    }

    /**
     * @param salePriceOld
     */
    public void setSalePriceOld(BigDecimal salePriceOld) {
        this.salePriceOld = salePriceOld;
    }

    /**
     * @return sale_price_new
     */
    public BigDecimal getSalePriceNew() {
        return salePriceNew;
    }

    /**
     * @param salePriceNew
     */
    public void setSalePriceNew(BigDecimal salePriceNew) {
        this.salePriceNew = salePriceNew;
    }

    /**
     * 获取赠送的积分
     *
     * @return gift_point_old - 赠送的积分
     */
    public Integer getGiftPointOld() {
        return giftPointOld;
    }

    /**
     * 设置赠送的积分
     *
     * @param giftPointOld 赠送的积分
     */
    public void setGiftPointOld(Integer giftPointOld) {
        this.giftPointOld = giftPointOld;
    }

    /**
     * @return gift_point_new
     */
    public Integer getGiftPointNew() {
        return giftPointNew;
    }

    /**
     * @param giftPointNew
     */
    public void setGiftPointNew(Integer giftPointNew) {
        this.giftPointNew = giftPointNew;
    }

    /**
     * @return use_point_limit_old
     */
    public Integer getUsePointLimitOld() {
        return usePointLimitOld;
    }

    /**
     * @param usePointLimitOld
     */
    public void setUsePointLimitOld(Integer usePointLimitOld) {
        this.usePointLimitOld = usePointLimitOld;
    }

    /**
     * @return use_point_limit_new
     */
    public Integer getUsePointLimitNew() {
        return usePointLimitNew;
    }

    /**
     * @param usePointLimitNew
     */
    public void setUsePointLimitNew(Integer usePointLimitNew) {
        this.usePointLimitNew = usePointLimitNew;
    }

    /**
     * 获取操作人
     *
     * @return operate_man - 操作人
     */
    public String getOperateMan() {
        return operateMan;
    }

    /**
     * 设置操作人
     *
     * @param operateMan 操作人
     */
    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
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
}