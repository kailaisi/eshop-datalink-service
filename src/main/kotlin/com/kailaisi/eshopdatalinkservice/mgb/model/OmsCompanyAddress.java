package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "oms_company_address")
public class OmsCompanyAddress extends BasePO<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 地址名称
     */
    @Column(name = "address_name")
    @ApiModelProperty("地址名称")
    private String addressName;

    /**
     * 默认发货地址：0->否；1->是
     */
    @Column(name = "send_status")
    @ApiModelProperty("默认发货地址：0->否；1->是")
    private Integer sendStatus;

    /**
     * 是否默认收货地址：0->否；1->是
     */
    @Column(name = "receive_status")
    @ApiModelProperty("是否默认收货地址：0->否；1->是")
    private Integer receiveStatus;

    /**
     * 收发货人姓名
     */
    @ApiModelProperty("收发货人姓名")
    private String name;

    /**
     * 收货人电话
     */
    @ApiModelProperty("收货人电话")
    private String phone;

    /**
     * 省/直辖市
     */
    @ApiModelProperty("省/直辖市")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty("市")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty("区")
    private String region;

    /**
     * 详细地址
     */
    @Column(name = "detail_address")
    @ApiModelProperty("详细地址")
    private String detailAddress;

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
     * 获取地址名称
     *
     * @return address_name - 地址名称
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * 设置地址名称
     *
     * @param addressName 地址名称
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * 获取默认发货地址：0->否；1->是
     *
     * @return send_status - 默认发货地址：0->否；1->是
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * 设置默认发货地址：0->否；1->是
     *
     * @param sendStatus 默认发货地址：0->否；1->是
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 获取是否默认收货地址：0->否；1->是
     *
     * @return receive_status - 是否默认收货地址：0->否；1->是
     */
    public Integer getReceiveStatus() {
        return receiveStatus;
    }

    /**
     * 设置是否默认收货地址：0->否；1->是
     *
     * @param receiveStatus 是否默认收货地址：0->否；1->是
     */
    public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    /**
     * 获取收发货人姓名
     *
     * @return name - 收发货人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置收发货人姓名
     *
     * @param name 收发货人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取收货人电话
     *
     * @return phone - 收货人电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置收货人电话
     *
     * @param phone 收货人电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取省/直辖市
     *
     * @return province - 省/直辖市
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省/直辖市
     *
     * @param province 省/直辖市
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
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
     * 获取详细地址
     *
     * @return detail_address - 详细地址
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 设置详细地址
     *
     * @param detailAddress 详细地址
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
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