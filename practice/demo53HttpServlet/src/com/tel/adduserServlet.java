package com.tel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addUserServlet")
public class adduserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get data
        String getName = request.getParameter("name");
        String getTel = request.getParameter("tel");

        Connection conn;
        Statement stat;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "aaaaaa");
            stat = conn.createStatement();
            String sql = "select name from usertable";
            ResultSet res = stat.executeQuery(sql);
            response.setContentType("application/json;charset=utf-8");
            Map<String,Object> mapMessage = new HashMap<String,Object>();
            while (res.next()) {
                if(res.getString("name").equals(getName)) {
                    mapMessage.put("userExist", true);
                    mapMessage.put("msg", "This name is existed, change a name please.");
                    System.out.println("exist");
                }else {
                    mapMessage.put("userExist", false);
                    mapMessage.put("msg", "This name is avaiable.");
                    System.out.println("not exist");
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
