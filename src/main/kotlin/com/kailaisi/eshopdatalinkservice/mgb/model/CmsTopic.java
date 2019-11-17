package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "cms_topic")
public class CmsTopic extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "category_id")
    @ApiModelProperty("")
    private Long categoryId;

    @ApiModelProperty("")
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @Column(name = "start_time")
    @ApiModelProperty("")
    private Date startTime;

    @Column(name = "end_time")
    @ApiModelProperty("")
    private Date endTime;

    /**
     * 参与人数
     */
    @Column(name = "attend_count")
    @ApiModelProperty("参与人数")
    private Integer attendCount;

    /**
     * 关注人数
     */
    @Column(name = "attention_count")
    @ApiModelProperty("关注人数")
    private Integer attentionCount;

    @Column(name = "read_count")
    @ApiModelProperty("")
    private Integer readCount;

    /**
     * 奖品名称
     */
    @Column(name = "award_name")
    @ApiModelProperty("奖品名称")
    private String awardName;

    /**
     * 参与方式
     */
    @Column(name = "attend_type")
    @ApiModelProperty("参与方式")
    private String attendType;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 话题内容
     */
    @ApiModelProperty("话题内容")
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
     * @return category_id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
     * 获取参与人数
     *
     * @return attend_count - 参与人数
     */
    public Integer getAttendCount() {
        return attendCount;
    }

    /**
     * 设置参与人数
     *
     * @param attendCount 参与人数
     */
    public void setAttendCount(Integer attendCount) {
        this.attendCount = attendCount;
    }

    /**
     * 获取关注人数
     *
     * @return attention_count - 关注人数
     */
    public Integer getAttentionCount() {
        return attentionCount;
    }

    /**
     * 设置关注人数
     *
     * @param attentionCount 关注人数
     */
    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
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
     * 获取奖品名称
     *
     * @return award_name - 奖品名称
     */
    public String getAwardName() {
        return awardName;
    }

    /**
     * 设置奖品名称
     *
     * @param awardName 奖品名称
     */
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    /**
     * 获取参与方式
     *
     * @return attend_type - 参与方式
     */
    public String getAttendType() {
        return attendType;
    }

    /**
     * 设置参与方式
     *
     * @param attendType 参与方式
     */
    public void setAttendType(String attendType) {
        this.attendType = attendType;
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
     * 获取话题内容
     *
     * @return content - 话题内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置话题内容
     *
     * @param content 话题内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}