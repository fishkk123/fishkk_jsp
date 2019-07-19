package com.bosssoft.hr.train.pojo.entity;

/**
 * 描述
 *
 * @author fishkk
 * @since
 */
public class User {
    /**
     * 用户名
     */
    private String code;
    /**
     * 用户密码
     */
    private String password;

    public User() {}

    public User(String code, String password) {
        this.code = code;
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
