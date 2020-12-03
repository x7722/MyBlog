package com.xuxu.myblog.entiy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 博客标签Count
 * @author MonsterXu
 * @date 2020-07-17
 */
public class BlogTagCount {
    private Integer tagId;  //标签id

    private String tagName; //标签名称

    private Integer tagCount;   //标签数量


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }
}
