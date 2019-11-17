package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "ums_integration_change_history")
public class UmsIntegrationChangeHistory extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "member_id")
    @ApiModelProperty("")
    private Long memberId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 改变类型：0->增加；1->减少
     */
    @Column(name = "change_type")
    @ApiModelProperty("改变类型：0->增加；1->减少")
    private Integer changeType;

    /**
     * 积分改变数量
     */
    @Column(name = "change_count")
    @ApiModelProperty("积分改变数量")
    private Integer changeCount;

    /**
     * 操作人员
     */
    @Column(name = "operate_man")
    @ApiModelProperty("操作人员")
    private String operateMan;

    /**
     * 操作备注
     */
    @Column(name = "operate_note")
    @ApiModelProperty("操作备注")
    private String operateNote;

    /**
     * 积分来源：0->购物；1->管理员修改
     */
    @Column(name = "source_type")
    @ApiModelProperty("积分来源：0->购物；1->管理员修改")
    private Integer sourceType;

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
     * 获取改变类型：0->增加；1->减少
     *
     * @return change_type - 改变类型：0->增加；1->减少
     */
    public Integer getChangeType() {
        return changeType;
    }

    /**
     * 设置改变类型：0->增加；1->减少
     *
     * @param changeType 改变类型：0->增加；1->减少
     */
    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    /**
     * 获取积分改变数量
     *
     * @return change_count - 积分改变数量
     */
    public Integer getChangeCount() {
        return changeCount;
    }

    /**
     * 设置积分改变数量
     *
     * @param changeCount 积分改变数量
     */
    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    /**
     * 获取操作人员
     *
     * @return operate_man - 操作人员
     */
    public String getOperateMan() {
        return operateMan;
    }

    /**
     * 设置操作人员
     *
     * @param operateMan 操作人员
     */
    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    /**
     * 获取操作备注
     *
     * @return operate_note - 操作备注
     */
    public String getOperateNote() {
        return operateNote;
    }

    /**
     * 设置操作备注
     *
     * @param operateNote 操作备注
     */
    public void setOperateNote(String operateNote) {
        this.operateNote = operateNote;
    }

    /**
     * 获取积分来源：0->购物；1->管理员修改
     *
     * @return source_type - 积分来源：0->购物；1->管理员修改
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     * 设置积分来源：0->购物；1->管理员修改
     *
     * @param sourceType 积分来源：0->购物；1->管理员修改
     */
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
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