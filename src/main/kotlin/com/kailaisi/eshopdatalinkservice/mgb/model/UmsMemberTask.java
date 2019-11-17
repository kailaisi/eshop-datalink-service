package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "ums_member_task")
public class UmsMemberTask extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("")
    private String name;

    /**
     * 赠送成长值
     */
    @ApiModelProperty("赠送成长值")
    private Integer growth;

    /**
     * 赠送积分
     */
    @ApiModelProperty("赠送积分")
    private Integer intergration;

    /**
     * 任务类型：0->新手任务；1->日常任务
     */
    @ApiModelProperty("任务类型：0->新手任务；1->日常任务")
    private Integer type;

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
     * 获取赠送成长值
     *
     * @return growth - 赠送成长值
     */
    public Integer getGrowth() {
        return growth;
    }

    /**
     * 设置赠送成长值
     *
     * @param growth 赠送成长值
     */
    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    /**
     * 获取赠送积分
     *
     * @return intergration - 赠送积分
     */
    public Integer getIntergration() {
        return intergration;
    }

    /**
     * 设置赠送积分
     *
     * @param intergration 赠送积分
     */
    public void setIntergration(Integer intergration) {
        this.intergration = intergration;
    }

    /**
     * 获取任务类型：0->新手任务；1->日常任务
     *
     * @return type - 任务类型：0->新手任务；1->日常任务
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置任务类型：0->新手任务；1->日常任务
     *
     * @param type 任务类型：0->新手任务；1->日常任务
     */
    public void setType(Integer type) {
        this.type = type;
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