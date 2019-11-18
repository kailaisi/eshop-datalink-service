package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "pms_brand")
public class PmsBrand extends BasePO<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("")
    private String name;

    /**
     * 首字母
     */
    @Column(name = "first_letter")
    @ApiModelProperty("首字母")
    private String firstLetter;

    @ApiModelProperty("")
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @Column(name = "factory_status")
    @ApiModelProperty("是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    @Column(name = "show_status")
    @ApiModelProperty("")
    private Integer showStatus;

    /**
     * 产品数量
     */
    @Column(name = "product_count")
    @ApiModelProperty("产品数量")
    private Integer productCount;

    /**
     * 产品评论数量
     */
    @Column(name = "product_comment_count")
    @ApiModelProperty("产品评论数量")
    private Integer productCommentCount;

    /**
     * 品牌logo
     */
    @ApiModelProperty("品牌logo")
    private String logo;

    /**
     * 专区大图
     */
    @Column(name = "big_pic")
    @ApiModelProperty("专区大图")
    private String bigPic;

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
     * 品牌故事
     */
    @Column(name = "brand_story")
    @ApiModelProperty("品牌故事")
    private String brandStory;

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
     * 获取首字母
     *
     * @return first_letter - 首字母
     */
    public String getFirstLetter() {
        return firstLetter;
    }

    /**
     * 设置首字母
     *
     * @param firstLetter 首字母
     */
    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否为品牌制造商：0->不是；1->是
     *
     * @return factory_status - 是否为品牌制造商：0->不是；1->是
     */
    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    /**
     * 设置是否为品牌制造商：0->不是；1->是
     *
     * @param factoryStatus 是否为品牌制造商：0->不是；1->是
     */
    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    /**
     * @return show_status
     */
    public Integer getShowStatus() {
        return showStatus;
    }

    /**
     * @param showStatus
     */
    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    /**
     * 获取产品数量
     *
     * @return product_count - 产品数量
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * 设置产品数量
     *
     * @param productCount 产品数量
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * 获取产品评论数量
     *
     * @return product_comment_count - 产品评论数量
     */
    public Integer getProductCommentCount() {
        return productCommentCount;
    }

    /**
     * 设置产品评论数量
     *
     * @param productCommentCount 产品评论数量
     */
    public void setProductCommentCount(Integer productCommentCount) {
        this.productCommentCount = productCommentCount;
    }

    /**
     * 获取品牌logo
     *
     * @return logo - 品牌logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置品牌logo
     *
     * @param logo 品牌logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取专区大图
     *
     * @return big_pic - 专区大图
     */
    public String getBigPic() {
        return bigPic;
    }

    /**
     * 设置专区大图
     *
     * @param bigPic 专区大图
     */
    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
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

    /**
     * 获取品牌故事
     *
     * @return brand_story - 品牌故事
     */
    public String getBrandStory() {
        return brandStory;
    }

    /**
     * 设置品牌故事
     *
     * @param brandStory 品牌故事
     */
    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }
}