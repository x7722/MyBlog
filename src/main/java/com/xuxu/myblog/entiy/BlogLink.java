package com.xuxu.myblog.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 友情连接
 * @author MonsterXu
 * @date 2020-07-17
 */
@Entity
@Table(name = "tb_link")
public class BlogLink {

    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="link_id")//数据库字段名
    private Integer linkId; //友链表主键id

    @Column(name="link_type")
    private Byte linkType;  //友链类别 默认0， 0-友链 1-推荐 2-个人网站

    @Column(name="link_name")
    private String linkName;    //网站名称

    @Column(name="link_url")
    private String linkUrl;     //网站链接

    @Column(name="link_description")
    private String linkDescription;     //网站描述

    @Column(name="link_rank")
    private Integer linkRank;       //用于列表排序 默认0

    @Column(name="is_deleted")
    private Byte isDeleted;     //是否删除 默认0  0-未删除 1-已删除

    @Column(name="create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;        //添加时间

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Byte getLinkType() {
        return linkType;
    }

    public void setLinkType(Byte linkType) {
        this.linkType = linkType;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription == null ? null : linkDescription.trim();
    }

    public Integer getLinkRank() {
        return linkRank;
    }

    public void setLinkRank(Integer linkRank) {
        this.linkRank = linkRank;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", linkId=").append(linkId);
        sb.append(", linkType=").append(linkType);
        sb.append(", linkName=").append(linkName);
        sb.append(", linkUrl=").append(linkUrl);
        sb.append(", linkDescription=").append(linkDescription);
        sb.append(", linkRank=").append(linkRank);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}