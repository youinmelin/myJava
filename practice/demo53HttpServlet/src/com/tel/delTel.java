package com.tel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/delTel")
public class delTel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String getId = req.getParameter("id");
        String referer = req.getHeader("Referer");
//        System.out.println("referer" + referer);
        Connection conn = null;
        Statement stat = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone=UTC","root","aaaaaa");
            stat = conn.createStatement();
            String sql = "delete from usertable where id = '" + getId + "'";
            stat.executeUpdate(sql);
            stat.close();
            conn.close();
            resp.sendRedirect(referer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
