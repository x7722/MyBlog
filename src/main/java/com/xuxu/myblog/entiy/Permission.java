package com.xuxu.myblog.entiy;

import javax.persistence.*;

/*****
 *  权限管理对象
 *  @author Monster Xu
 *  @date 2020/12/3
 *****/
@Entity
@Table(name = "tb_admin_permission")
public class Permission {

    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;    //权限id

    @Column(name = "code")
    private String code;      //权限代码

    @Column(name = "name")
    private String name;    //权限名称

    @Column(name = "description")
    private String description; //权限描述


    public Permission() {
    }

    public Permission(String code, String name, String description) {
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
        return "Permission{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
