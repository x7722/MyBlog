package com.xuxu.myblog.entiy;

import javax.persistence.*;
import java.util.Date;

/**
 * 博客和标签关系
 * @author MonsterXu
 * @date 2020-07-17
 */

@Entity
@Table(name = "tb_blog_tag_relation")
public class BlogTagRelation {

    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="relation_id")//数据库字段名
    private Long relationId;    //关系id

    @Column(name="blog_id")
    private Long blogId;    //博客id

    @Column(name="tag_id")
    private Integer tagId;  //标签id

    @Column(name="create_time")
    private Date createTime;    //创建时间

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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
        sb.append(", relationId=").append(relationId);
        sb.append(", blogId=").append(blogId);
        sb.append(", tagId=").append(tagId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}