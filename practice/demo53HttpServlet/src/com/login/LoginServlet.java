package com.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*用户登录案例需求：
        1.编写login.html登录页面
        username & password 两个输入框
        2.使用Druid数据库连接池技术,操作mysql，day14数据库中user表
        3.使用JdbcTemplate技术封装JDBC
        4.登录成功跳转到SuccessServlet展示：登录成功！用户名,欢迎您
        5.登录失败跳转到FailServlet展示：登录失败，用户名或密码错误*/

@WebServlet("/newlogin")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // System.out.println(username);
        // System.out.println(password);
        boolean ret = loginCheck(username, password);
        System.out.println(ret);
        if (ret) {
            request.getRequestDispatcher("/SuccessServlet").forword(request, response);
        }else {
            request.getRequestDispatcher("/FailServlet").forword(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private boolean loginCheck(String username, String password) {
        Properties pro = new Properties();
        Inputstream is = Login.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        String sql = "select id from users where name = ? and password = ?";
        PrepareStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        boolean ret = rs.next();
        rs.close();
        is.close();
        JDBCUtils.close(ps, conn);
        return ret;
    }
}
