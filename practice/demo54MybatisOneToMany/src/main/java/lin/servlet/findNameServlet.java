package lin.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import lin.dao.IUserDao;
import lin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet( "/findNameServlet")
public class findNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("content-Type", "text/html;charset=utf-8");
//        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        System.out.println("findName:" + name);
        Map<String, Object> map = new HashMap<String, Object>();

        String nameExisted = "郑林";

        // use mybatis dao
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setName(name);
        List<User> users = userDao.findByUser(user);
        System.out.println(users.size());
        int nameCount = users.size();

        if(nameCount > 0) {
            map.put("nameExist",true);
            map.put("msg",name + " is existed.");
        }else {
            map.put("nameExist",false);
            map.put("msg",name + " is new.");
        }
        // map to json;
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(response.getWriter(),map);
    }
}
