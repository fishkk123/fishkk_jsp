package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.dao.IUserDao;
import com.bosssoft.hr.train.dao.UserDaoImpl;

/**
 * 描述
 *
 * @author fishkk
 * @since
 */
public class UserService implements ILogin {
    IUserDao userDao = new UserDaoImpl();
    @Override
    public boolean isRight(String code, String password) {
        return userDao.isRight(code,password);
    }
}
