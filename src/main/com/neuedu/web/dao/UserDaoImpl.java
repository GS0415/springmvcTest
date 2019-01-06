package com.neuedu.web.dao;

import com.neuedu.web.pojo.User;

import com.neuedu.web.util.IRowMap;
import com.neuedu.web.util.JdbcUtil;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public int add(User user) {
        return JdbcUtil.zsg("insert into user(username,password,tel,sex) values(?,?,?,?)", user.getUserName(), user.getPassWord(), user.getTel(),user.getSex());
    }

    @Override
    public int del(int id) {
        return JdbcUtil.zsg("delete from user where id=?",id);
    }

    @Override
    public int update(User user) {
        return JdbcUtil.zsg("update user set username=?,tel=?,sex=?, password=? where id=?",user.getUserName(),user.getTel(),user.getSex(),user.getPassWord(),user.getUserId());
    }

    @Override
    public List<User> sel() {
        return JdbcUtil.select("select * from user", new IRowMap<User>() {
            @Override
            public User rowMap(ResultSet rs) {
                User user = new User();
                try {
                    user.setPassWord(rs.getString("password"));
                    user.setUserName(rs.getString("username"));
                    user.setUserId(rs.getInt("id"));
                    user.setTel(rs.getString("tel"));
                    user.setPhoto(rs.getString("photo"));
                    user.setSex(rs.getString("sex"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        },null);
    }


    @Override
    public User selOne(int id) {
        return JdbcUtil.selectOne("select * from user where id=?", new IRowMap<User>() {
            @Override
            public User rowMap(ResultSet rs) {
                User user = new User();
                try {
                    user.setPassWord(rs.getString("password"));
                    user.setUserName(rs.getString("username"));
                    user.setUserId(rs.getInt("id"));
                    user.setTel(rs.getString("tel"));
                    user.setPhoto(rs.getString("photo"));
                    user.setSex(rs.getString("sex"));
                    user.setQuan(rs.getString("quan"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        }, id);
    }
    @Override
    public User selOneUser(String name) {
        return JdbcUtil.selectOne("select * from user where username=?", new IRowMap<User>() {
            @Override
            public User rowMap(ResultSet rs) {
                User user = new User();
                try {
                    user.setPassWord(rs.getString("password"));
                    user.setUserId(rs.getInt("id"));
                    user.setUserName(rs.getString("username"));
                    user.setTel(rs.getString("tel"));
                    user.setPhoto(rs.getString("photo"));
                    user.setSex(rs.getString("sex"));
                    user.setQuan(rs.getString("quan"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        }, name);
    }
}
