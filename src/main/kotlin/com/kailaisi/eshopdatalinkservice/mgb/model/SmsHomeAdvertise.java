package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "sms_home_advertise")
public class SmsHomeAdvertise extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("")
    private String name;

    /**
     * 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    @ApiModelProperty("轮播位置：0->PC首页轮播；1->app首页轮播")
    private Integer type;

    @ApiModelProperty("")
    private String pic;

    @Column(name = "start_time")
    @ApiModelProperty("")
    private Date startTime;

    @Column(name = "end_time")
    @ApiModelProperty("")
    private Date endTime;

    /**
     * 上下线状态：0->下线；1->上线
     */
    @ApiModelProperty("上下线状态：0->下线；1->上线")
    private Integer status;

    /**
     * 点击数
     */
    @Column(name = "click_count")
    @ApiModelProperty("点击数")
    private Integer clickCount;

    /**
     * 下单数
     */
    @Column(name = "order_count")
    @ApiModelProperty("下单数")
    private Integer orderCount;

    /**
     * 链接地址
     */
    @ApiModelProperty("链接地址")
    private String url;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String note;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

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
     * 获取轮播位置：0->PC首页轮播；1->app首页轮播
     *
     * @return type - 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置轮播位置：0->PC首页轮播；1->app首页轮播
     *
     * @param type 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取上下线状态：0->下线；1->上线
     *
     * @return status - 上下线状态：0->下线；1->上线
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置上下线状态：0->下线；1->上线
     *
     * @param status 上下线状态：0->下线；1->上线
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取点击数
     *
     * @return click_count - 点击数
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * 设置点击数
     *
     * @param clickCount 点击数
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * 获取下单数
     *
     * @return order_count - 下单数
     */
    public Integer getOrderCount() {
        return orderCount;
    }

    /**
     * 设置下单数
     *
     * @param orderCount 下单数
     */
    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    /**
     * 获取链接地址
     *
     * @return url - 链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接地址
     *
     * @param url 链接地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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