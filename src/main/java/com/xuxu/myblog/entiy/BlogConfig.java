package com.xuxu.myblog.entiy;

import javax.persistence.*;
import java.util.Date;

/**
 * 博客配置
 * @author MonsterXu
 * @date 2020-07-17
 */

@Entity
@Table(name = "tb_config")
public class BlogConfig {

    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="config_name")//数据库字段名
    private String configName;      //配置项名称

    @Column(name="config_value")
    private String configValue;     //配置项的值

    @Column(name="create_time")
    private Date createTime;        //创建时间

    @Column(name="update_time")
    private Date updateTime;        //修改时间

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", configName=").append(configName);
        sb.append(", configValue=").append(configValue);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}