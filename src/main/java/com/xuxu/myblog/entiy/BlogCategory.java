package com.xuxu.myblog.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 博客分类
 * @author MonsterXu
 * @date 2020-07-17
 */

@Entity
@Table(name = "tb_blog_category")
public class BlogCategory {

    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="category_id")//数据库字段名
    private Integer categoryId;     //分类id

    @Column(name="category_name")
    private String categoryName;    //分类名称

    @Column(name="category_icon")
    private String categoryIcon;    //分类图标

    @Column(name="category_rank")
    private Integer categoryRank;   //分类排序值 默认1，被使用的越多，数值越大，排序越靠前

    @Column(name="is_deleted")
    private Byte isDeleted;     //是否删除 默认0， 0否 1是

    @Column(name="create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;



    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon == null ? null : categoryIcon.trim();
    }

    public Integer getCategoryRank() {
        return categoryRank;
    }

    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
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
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryIcon=").append(categoryIcon);
        sb.append(", categoryRank=").append(categoryRank);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}