package com.lin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/login")
public class HttpServlet02Request extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method);
        String username = req.getParameter("username");
        System.out.println("username-->" + username);
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            String[] value = parameterMap.get(name);
            for (String s : value) {
                System.out.println(s);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
