package com.neuedu.web.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {  //  Jdbc 工具类  写所有方法
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf8";
    private static final String USE = "root";
    private static final String PWD = "123456";

    // 加载驱动
    static {
        try {
            new com.mysql.jdbc.Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //创建（封装）连接方法
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USE, PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //创建（封装）关闭方法
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //创建（封装）增 删 改 方法
    public static int zsg(String sql, Object... obj) {
        int a = 0;

        PreparedStatement pstmt = null;
        Connection conn = null;

        // 创建连接 调用连接方法
        conn = getConnection();

        //创建 sql 预处理语句 直接写在这里是死的  所以让用户传进来
        /*String sql="insert into p(id,name,subtitle,detail,price,stock) values(?,?,?,?,?,?)";*/
        //创建窗口
        try {
            pstmt = conn.prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {    // 循环添加
                    pstmt.setObject(i + 1, obj[i]);
                }
            }
            // 执行  返回值为 int 类型的  影响行数
            a = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {  //关闭
            close(null, pstmt, conn);
        }
        return a;
    }

    //创建（封装） 查询一个方法
    public static <T> T selectOne(String sql, IRowMap<T> rm, Object... obj) {
        T t = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pstmt.setObject(i + 1, obj[i]);
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                t = rm.rowMap(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(rs, pstmt, conn);
        return t;
    }

    //创建（封装） 查询方法
    public static <T> List<T> select(String sql, IRowMap<T> rm, Object... obj) {
        List<T> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pstmt.setObject(i + 1, obj[i]);
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                T t = rm.rowMap(rs);
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(rs, pstmt, conn);
        /*System.out.println("工具类中");
        for (T t:list
        ) {
            System.out.println(t);
        }*/
        return list;
    }
    public static <T> int executeCount(String sql, Object... obj){
        int a =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn=getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    pstmt.setObject(i+1,obj[i]);
                }
            }
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                a=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
