package com.xuxu.myblog.entiy;

import javax.persistence.*;

/*****
 *  角色管理对象
 *  @author Monster Xu
 *  @date 2020/12/3
 *****/
@Entity
@Table(name = "tb_admin_role")
public class Role {

    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;    //角色id

    @Column(name = "code")
    private String code;      //角色代码

    @Column(name = "name")
    private String name;    //角色名称

    @Column(name = "description")
    private String description; //角色描述

    public Role() {
    }

    public Role(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
