package com.bosssoft.hr.train.dao;

/**
 * 描述
 *
 * @author fishkk
 * @since
 */
public interface IUserDao {
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
    /**
      * 判断用户名是否存在
      * @author fishkk
      * @since 2019/4/25
      *
      * @param code
      * @return  boolean
      */
    boolean isExist(String code);
}
