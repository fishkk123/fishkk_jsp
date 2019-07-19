package com.bosssoft.hr.train.dao;

import com.bosssoft.hr.train.until.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 描述
 *
 * @author fishkk
 * @since
 */
public class UserDaoImpl implements IUserDao{

    /**
     * 正确的返回值
     */
    private static final String PASSWORD = "userPassword";

    @Override
    public boolean isRight(String code, String password) {
        String sql = "SELECT * FROM user WHERE userCode=?";
        try (Connection c = DbUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString(PASSWORD).equals(password)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return false;
    }

    @Override
    public boolean isExist(String code){
        String sql = "SELECT * FROM user WHERE userCode=?";
        try (Connection c = DbUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                    return true;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
