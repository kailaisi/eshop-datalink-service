package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "oms_cart_item")
public class OmsCartItem extends BasePO<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "product_id")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "product_sku_id")
    @ApiModelProperty("")
    private Long productSkuId;

    @Column(name = "member_id")
    @ApiModelProperty("")
    private Long memberId;

    /**
     * 购买数量
     */
    @ApiModelProperty("购买数量")
    private Integer quantity;

    /**
     * 添加到购物车的价格
     */
    @ApiModelProperty("添加到购物车的价格")
    private BigDecimal price;

    /**
     * 销售属性1
     */
    @ApiModelProperty("销售属性1")
    private String sp1;

    /**
     * 销售属性2
     */
    @ApiModelProperty("销售属性2")
    private String sp2;

    /**
     * 销售属性3
     */
    @ApiModelProperty("销售属性3")
    private String sp3;

    /**
     * 商品主图
     */
    @Column(name = "product_pic")
    @ApiModelProperty("商品主图")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    @ApiModelProperty("商品名称")
    private String productName;

    /**
     * 商品副标题（卖点）
     */
    @Column(name = "product_sub_title")
    @ApiModelProperty("商品副标题（卖点）")
    private String productSubTitle;

    /**
     * 商品sku条码
     */
    @Column(name = "product_sku_code")
    @ApiModelProperty("商品sku条码")
    private String productSkuCode;

    /**
     * 会员昵称
     */
    @Column(name = "member_nickname")
    @ApiModelProperty("会员昵称")
    private String memberNickname;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @ApiModelProperty("创建时间")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "modify_date")
    @ApiModelProperty("修改时间")
    private Date modifyDate;

    /**
     * 是否删除
     */
    @Column(name = "delete_status")
    @ApiModelProperty("是否删除")
    private Integer deleteStatus;

    /**
     * 商品分类
     */
    @Column(name = "product_category_id")
    @ApiModelProperty("商品分类")
    private Long productCategoryId;

    @Column(name = "product_brand")
    @ApiModelProperty("")
    private String productBrand;

    @Column(name = "product_sn")
    @ApiModelProperty("")
    private String productSn;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    @Column(name = "product_attr")
    @ApiModelProperty("商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]")
    private String productAttr;

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
     * @return product_sku_id
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    /**
     * @param productSkuId
     */
    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * @return member_id
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取购买数量
     *
     * @return quantity - 购买数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置购买数量
     *
     * @param quantity 购买数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取添加到购物车的价格
     *
     * @return price - 添加到购物车的价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置添加到购物车的价格
     *
     * @param price 添加到购物车的价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取销售属性1
     *
     * @return sp1 - 销售属性1
     */
    public String getSp1() {
        return sp1;
    }

    /**
     * 设置销售属性1
     *
     * @param sp1 销售属性1
     */
    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    /**
     * 获取销售属性2
     *
     * @return sp2 - 销售属性2
     */
    public String getSp2() {
        return sp2;
    }

    /**
     * 设置销售属性2
     *
     * @param sp2 销售属性2
     */
    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    /**
     * 获取销售属性3
     *
     * @return sp3 - 销售属性3
     */
    public String getSp3() {
        return sp3;
    }

    /**
     * 设置销售属性3
     *
     * @param sp3 销售属性3
     */
    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    /**
     * 获取商品主图
     *
     * @return product_pic - 商品主图
     */
    public String getProductPic() {
        return productPic;
    }

    /**
     * 设置商品主图
     *
     * @param productPic 商品主图
     */
    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取商品副标题（卖点）
     *
     * @return product_sub_title - 商品副标题（卖点）
     */
    public String getProductSubTitle() {
        return productSubTitle;
    }

    /**
     * 设置商品副标题（卖点）
     *
     * @param productSubTitle 商品副标题（卖点）
     */
    public void setProductSubTitle(String productSubTitle) {
        this.productSubTitle = productSubTitle;
    }

    /**
     * 获取商品sku条码
     *
     * @return product_sku_code - 商品sku条码
     */
    public String getProductSkuCode() {
        return productSkuCode;
    }

    /**
     * 设置商品sku条码
     *
     * @param productSkuCode 商品sku条码
     */
    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    /**
     * 获取会员昵称
     *
     * @return member_nickname - 会员昵称
     */
    public String getMemberNickname() {
        return memberNickname;
    }

    /**
     * 设置会员昵称
     *
     * @param memberNickname 会员昵称
     */
    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取修改时间
     *
     * @return modify_date - 修改时间
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * 设置修改时间
     *
     * @param modifyDate 修改时间
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * 获取是否删除
     *
     * @return delete_status - 是否删除
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置是否删除
     *
     * @param deleteStatus 是否删除
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取商品分类
     *
     * @return product_category_id - 商品分类
     */
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * 设置商品分类
     *
     * @param productCategoryId 商品分类
     */
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * @return product_brand
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * @param productBrand
     */
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    /**
     * @return product_sn
     */
    public String getProductSn() {
        return productSn;
    }

    /**
     * @param productSn
     */
    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    /**
     * 获取商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     *
     * @return product_attr - 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    public String getProductAttr() {
        return productAttr;
    }

    /**
     * 设置商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     *
     * @param productAttr 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
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