package com.xuxu.myblog.entiy;

import javax.persistence.*;

/**
 * 管理员
 * @author MonsterXu
 * @date 2020-07-17
 */
@Entity
@Table(name = "tb_admin_user")
public class AdminUser {

    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="admin_user_id")//数据库字段名
    private Integer adminUserId;    //管理员id

    @Column(name = "login_user_name")
    private String loginUserName;       //管理员登陆名称

    @Column(name = "login_password")
    private String loginPassword;      //管理员登陆密码

    @Column(name = "nick_name")
    private String nickName;        //管理员昵称

    @Column(name = "locked")
    private Byte locked;        //是否锁定 0未锁定，1已锁定无法登陆

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName == null ? null : loginUserName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminUserId=").append(adminUserId);
        sb.append(", loginUserName=").append(loginUserName);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", nickName=").append(nickName);
        sb.append(", locked=").append(locked);
        sb.append("]");
        return sb.toString();
    }

}