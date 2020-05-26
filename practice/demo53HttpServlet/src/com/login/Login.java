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
        System.out.println(username);
        System.out.println(password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
