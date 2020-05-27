package com.login;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
/*用户登录案例需求：
        1.编写login.html登录页面
        username & password 两个输入框
        2.使用Druid数据库连接池技术,操作mysql，day14数据库中user表
        3.使用JdbcTemplate技术封装JDBC
        4.登录成功跳转到SuccessServlet展示：登录成功！用户名,欢迎您
        5.登录失败跳转到FailServlet展示：登录失败，用户名或密码错误*/

@WebServlet("/newlogin")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         System.out.println(username);
         System.out.println(password);
        boolean ret;
        try {
            ret = loginCheck(username, password);
            System.out.println(ret);
            if (ret) {
                request.getRequestDispatcher("/SuccessServlet").forward(request, response);
            }else {
                request.getRequestDispatcher("/FailServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private boolean loginCheck(String username, String password) throws Exception {
        Properties pro = new Properties();
        InputStream is = LoginServlet.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        String sql = "select id from users where name = ? and password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        boolean ret = rs.next();
        System.out.println("ret" + ret);
        rs.close();
        is.close();
        ps.close();
        conn.close();

        return ret;
    }
}
