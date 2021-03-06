package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "ums_member_receive_address")
public class UmsMemberReceiveAddress extends BasePO<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "member_id")
    @ApiModelProperty("")
    private Long memberId;

    /**
     * 收货人名称
     */
    @ApiModelProperty("收货人名称")
    private String name;

    @Column(name = "phone_number")
    @ApiModelProperty("")
    private String phoneNumber;

    /**
     * 是否为默认
     */
    @Column(name = "default_status")
    @ApiModelProperty("是否为默认")
    private Integer defaultStatus;

    /**
     * 邮政编码
     */
    @Column(name = "post_code")
    @ApiModelProperty("邮政编码")
    private String postCode;

    /**
     * 省份/直辖市
     */
    @ApiModelProperty("省份/直辖市")
    private String province;

    /**
     * 城市
     */
    @ApiModelProperty("城市")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty("区")
    private String region;

    /**
     * 详细地址(街道)
     */
    @Column(name = "detail_address")
    @ApiModelProperty("详细地址(街道)")
    private String detailAddress;

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
     * 获取收货人名称
     *
     * @return name - 收货人名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置收货人名称
     *
     * @param name 收货人名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取是否为默认
     *
     * @return default_status - 是否为默认
     */
    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    /**
     * 设置是否为默认
     *
     * @param defaultStatus 是否为默认
     */
    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    /**
     * 获取邮政编码
     *
     * @return post_code - 邮政编码
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 设置邮政编码
     *
     * @param postCode 邮政编码
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * 获取省份/直辖市
     *
     * @return province - 省份/直辖市
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份/直辖市
     *
     * @param province 省份/直辖市
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区
     *
     * @return region - 区
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置区
     *
     * @param region 区
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 获取详细地址(街道)
     *
     * @return detail_address - 详细地址(街道)
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 设置详细地址(街道)
     *
     * @param detailAddress 详细地址(街道)
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
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