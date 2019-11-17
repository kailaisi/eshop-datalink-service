package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "pms_comment")
public class PmsComment extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "product_id")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "member_nick_name")
    @ApiModelProperty("")
    private String memberNickName;

    @Column(name = "product_name")
    @ApiModelProperty("")
    private String productName;

    /**
     * 评价星数：0->5
     */
    @ApiModelProperty("评价星数：0->5")
    private Integer star;

    /**
     * 评价的ip
     */
    @Column(name = "member_ip")
    @ApiModelProperty("评价的ip")
    private String memberIp;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @Column(name = "show_status")
    @ApiModelProperty("")
    private Integer showStatus;

    /**
     * 购买时的商品属性
     */
    @Column(name = "product_attribute")
    @ApiModelProperty("购买时的商品属性")
    private String productAttribute;

    @Column(name = "collect_couont")
    @ApiModelProperty("")
    private Integer collectCouont;

    @Column(name = "read_count")
    @ApiModelProperty("")
    private Integer readCount;

    /**
     * 上传图片地址，以逗号隔开
     */
    @ApiModelProperty("上传图片地址，以逗号隔开")
    private String pics;

    /**
     * 评论用户头像
     */
    @Column(name = "member_icon")
    @ApiModelProperty("评论用户头像")
    private String memberIcon;

    @Column(name = "replay_count")
    @ApiModelProperty("")
    private Integer replayCount;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("")
    private String content;

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
     * @return member_nick_name
     */
    public String getMemberNickName() {
        return memberNickName;
    }

    /**
     * @param memberNickName
     */
    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    /**
     * @return product_name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取评价星数：0->5
     *
     * @return star - 评价星数：0->5
     */
    public Integer getStar() {
        return star;
    }

    /**
     * 设置评价星数：0->5
     *
     * @param star 评价星数：0->5
     */
    public void setStar(Integer star) {
        this.star = star;
    }

    /**
     * 获取评价的ip
     *
     * @return member_ip - 评价的ip
     */
    public String getMemberIp() {
        return memberIp;
    }

    /**
     * 设置评价的ip
     *
     * @param memberIp 评价的ip
     */
    public void setMemberIp(String memberIp) {
        this.memberIp = memberIp;
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
     * 获取购买时的商品属性
     *
     * @return product_attribute - 购买时的商品属性
     */
    public String getProductAttribute() {
        return productAttribute;
    }

    /**
     * 设置购买时的商品属性
     *
     * @param productAttribute 购买时的商品属性
     */
    public void setProductAttribute(String productAttribute) {
        this.productAttribute = productAttribute;
    }

    /**
     * @return collect_couont
     */
    public Integer getCollectCouont() {
        return collectCouont;
    }

    /**
     * @param collectCouont
     */
    public void setCollectCouont(Integer collectCouont) {
        this.collectCouont = collectCouont;
    }

    /**
     * @return read_count
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * @param readCount
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     * 获取上传图片地址，以逗号隔开
     *
     * @return pics - 上传图片地址，以逗号隔开
     */
    public String getPics() {
        return pics;
    }

    /**
     * 设置上传图片地址，以逗号隔开
     *
     * @param pics 上传图片地址，以逗号隔开
     */
    public void setPics(String pics) {
        this.pics = pics;
    }

    /**
     * 获取评论用户头像
     *
     * @return member_icon - 评论用户头像
     */
    public String getMemberIcon() {
        return memberIcon;
    }

    /**
     * 设置评论用户头像
     *
     * @param memberIcon 评论用户头像
     */
    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon;
    }

    /**
     * @return replay_count
     */
    public Integer getReplayCount() {
        return replayCount;
    }

    /**
     * @param replayCount
     */
    public void setReplayCount(Integer replayCount) {
        this.replayCount = replayCount;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}