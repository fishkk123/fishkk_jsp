package com.bosssoft.hr.train.service;

/**
 * 描述
 *
 * @author fishkk
 * @since
 */
public interface ILogin {
    /**
     * 判断是否为合法用户
     * @author fishkk
     * @since 2019/4/25
     *
     * @param code
     * @param password
     * @return boolean
     */
    boolean isRight(String code, String password);
}
