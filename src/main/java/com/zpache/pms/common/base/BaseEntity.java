package com.zpache.pms.common.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 16:52
 */
public class BaseEntity {
    @TableId
    protected Long id;
    @TableField(value = "is_delete")
    protected Integer isDelete;
    @TableField(value = "create_by")
    protected String createBy;
    @TableField(value = "create_time")
    protected Date createTime;
    @TableField(value = "update_by")
    protected String updateBy;
    @TableField(value = "update_time")
    protected Date updateTime;
    @TableField(value = "version")
    protected Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
