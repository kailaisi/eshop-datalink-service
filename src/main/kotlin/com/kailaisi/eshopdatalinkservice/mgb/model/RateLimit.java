package com.kailaisi.eshopdatalinkservice.mgb.model;

import com.kailaisi.eshopdatalinkservice.mgb.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel("")
@Table(name = "rate_limit")
public class RateLimit extends BasePO<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String url;

    @ApiModelProperty("")
    private Integer limit;

    @Column(name = "update_time")
    @ApiModelProperty("")
    private Date updateTime;

    @Column(name = "create_time")
    @ApiModelProperty("")
    private Date createTime;

    @ApiModelProperty("")
    private Integer max;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * @param limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return max
     */
    public Integer getMax() {
        return max;
    }

    /**
     * @param max
     */
    public void setMax(Integer max) {
        this.max = max;
    }
}