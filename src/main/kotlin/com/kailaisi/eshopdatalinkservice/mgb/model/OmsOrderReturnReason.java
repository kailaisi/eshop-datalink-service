package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "oms_order_return_reason")
public class OmsOrderReturnReason extends BasePO<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 退货类型
     */
    @ApiModelProperty("退货类型")
    private String name;

    @ApiModelProperty("")
    private Integer sort;

    /**
     * 状态：0->不启用；1->启用
     */
    @ApiModelProperty("状态：0->不启用；1->启用")
    private Integer status;

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
     * 获取退货类型
     *
     * @return name - 退货类型
     */
    public String getName() {
        return name;
    }

    /**
     * 设置退货类型
     *
     * @param name 退货类型
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取状态：0->不启用；1->启用
     *
     * @return status - 状态：0->不启用；1->启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：0->不启用；1->启用
     *
     * @param status 状态：0->不启用；1->启用
     */
    public void setStatus(Integer status) {
        this.status = status;
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