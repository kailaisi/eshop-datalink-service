package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "ums_role")
public class UmsRole extends BasePO<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

    /**
     * 后台用户数量
     */
    @Column(name = "admin_count")
    @ApiModelProperty("后台用户数量")
    private Integer adminCount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 启用状态：0->禁用；1->启用
     */
    @ApiModelProperty("启用状态：0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty("")
    private Integer sort;

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取后台用户数量
     *
     * @return admin_count - 后台用户数量
     */
    public Integer getAdminCount() {
        return adminCount;
    }

    /**
     * 设置后台用户数量
     *
     * @param adminCount 后台用户数量
     */
    public void setAdminCount(Integer adminCount) {
        this.adminCount = adminCount;
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
     * 获取启用状态：0->禁用；1->启用
     *
     * @return status - 启用状态：0->禁用；1->启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置启用状态：0->禁用；1->启用
     *
     * @param status 启用状态：0->禁用；1->启用
     */
    public void setStatus(Integer status) {
        this.status = status;
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