package com.xuxu.myblog.entiy;

import javax.persistence.*;
import java.util.Date;

/**
 * 管理员用户对象
 * @author MonsterXu
 * @date 2020-07-17
 */
@Entity
@Table(name = "tb_admin_user")
public class AdminUser {

    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="id")//数据库字段名
    private Integer id;    //管理员id

    @Column(name = "username")
    private String username;       //管理员登陆名称

    @Column(name = "passwd")
    private String passwd;      //管理员登陆密码

    @Column(name = "nick_name")
    private String nickName;        //管理员昵称

    @Column(name = "locked")
    private Byte locked;        //是否锁定 0未锁定，1已锁定无法登陆

    @Column(name = "create_time")
    private Date createTime;        //添加时间

    @Column(name = "update_time")
    private Date updateTime;        //修改时间


    public AdminUser() {
    }

    public AdminUser(String username, String passwd, String nickName) {
        this.username = username;
        this.passwd = passwd;
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
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
        return "AdminUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", locked=" + locked +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}