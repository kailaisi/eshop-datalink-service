package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "cms_member_report")
public class CmsMemberReport extends BaseModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
    @Column(name = "report_type")
    @ApiModelProperty("举报类型：0->商品评价；1->话题内容；2->用户评论")
    private Integer reportType;

    /**
     * 举报人
     */
    @Column(name = "report_member_name")
    @ApiModelProperty("举报人")
    private String reportMemberName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @Column(name = "report_object")
    @ApiModelProperty("")
    private String reportObject;

    /**
     * 举报状态：0->未处理；1->已处理
     */
    @Column(name = "report_status")
    @ApiModelProperty("举报状态：0->未处理；1->已处理")
    private Integer reportStatus;

    /**
     * 处理结果：0->无效；1->有效；2->恶意
     */
    @Column(name = "handle_status")
    @ApiModelProperty("处理结果：0->无效；1->有效；2->恶意")
    private Integer handleStatus;

    @ApiModelProperty("")
    private String note;

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
     * 获取举报类型：0->商品评价；1->话题内容；2->用户评论
     *
     * @return report_type - 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
    public Integer getReportType() {
        return reportType;
    }

    /**
     * 设置举报类型：0->商品评价；1->话题内容；2->用户评论
     *
     * @param reportType 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    /**
     * 获取举报人
     *
     * @return report_member_name - 举报人
     */
    public String getReportMemberName() {
        return reportMemberName;
    }

    /**
     * 设置举报人
     *
     * @param reportMemberName 举报人
     */
    public void setReportMemberName(String reportMemberName) {
        this.reportMemberName = reportMemberName;
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
     * @return report_object
     */
    public String getReportObject() {
        return reportObject;
    }

    /**
     * @param reportObject
     */
    public void setReportObject(String reportObject) {
        this.reportObject = reportObject;
    }

    /**
     * 获取举报状态：0->未处理；1->已处理
     *
     * @return report_status - 举报状态：0->未处理；1->已处理
     */
    public Integer getReportStatus() {
        return reportStatus;
    }

    /**
     * 设置举报状态：0->未处理；1->已处理
     *
     * @param reportStatus 举报状态：0->未处理；1->已处理
     */
    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    /**
     * 获取处理结果：0->无效；1->有效；2->恶意
     *
     * @return handle_status - 处理结果：0->无效；1->有效；2->恶意
     */
    public Integer getHandleStatus() {
        return handleStatus;
    }

    /**
     * 设置处理结果：0->无效；1->有效；2->恶意
     *
     * @param handleStatus 处理结果：0->无效；1->有效；2->恶意
     */
    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
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