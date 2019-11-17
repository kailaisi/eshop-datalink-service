package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "ums_permission")
public class UmsPermission extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 父级权限id
     */
    @ApiModelProperty("父级权限id")
    private Long pid;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 权限值
     */
    @ApiModelProperty("权限值")
    private String value;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    @ApiModelProperty("权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    private Integer type;

    /**
     * 前端资源路径
     */
    @ApiModelProperty("前端资源路径")
    private String uri;

    /**
     * 启用状态；0->禁用；1->启用
     */
    @ApiModelProperty("启用状态；0->禁用；1->启用")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

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
     * 获取父级权限id
     *
     * @return pid - 父级权限id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父级权限id
     *
     * @param pid 父级权限id
     */
    public void setPid(Long pid) {
        this.pid = pid;
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
     * 获取权限值
     *
     * @return value - 权限值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置权限值
     *
     * @param value 权限值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     *
     * @return type - 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     *
     * @param type 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取前端资源路径
     *
     * @return uri - 前端资源路径
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置前端资源路径
     *
     * @param uri 前端资源路径
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 获取启用状态；0->禁用；1->启用
     *
     * @return status - 启用状态；0->禁用；1->启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置启用状态；0->禁用；1->启用
     *
     * @param status 启用状态；0->禁用；1->启用
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
}