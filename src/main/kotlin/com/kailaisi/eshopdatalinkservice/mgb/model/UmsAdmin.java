package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "ums_admin")
public class UmsAdmin extends BasePO<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("")
    private String username;

    @ApiModelProperty("")
    private String password;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String icon;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 备注信息
     */
    @ApiModelProperty("备注信息")
    private String note;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(name = "login_time")
    @ApiModelProperty("最后登录时间")
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    private Integer status;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取头像
     *
     * @return icon - 头像
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置头像
     *
     * @param icon 头像
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取备注信息
     *
     * @return note - 备注信息
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注信息
     *
     * @param note 备注信息
     */
    public void setNote(String note) {
        this.note = note;
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
     * 获取最后登录时间
     *
     * @return login_time - 最后登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param loginTime 最后登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取帐号启用状态：0->禁用；1->启用
     *
     * @return status - 帐号启用状态：0->禁用；1->启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置帐号启用状态：0->禁用；1->启用
     *
     * @param status 帐号启用状态：0->禁用；1->启用
     */
    public void setStatus(Integer status) {
        this.status = status;
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