package lin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/")
    @ResponseBody  // 返回的是字符串，所以要加上ResponseBody
    public String hello() throws JsonProcessingException {
//        List users = new ArrayList();
        User user = new User();
        user.setId(1);
        user.setUsername("lin");
        user.setGender("male");
        ObjectMapper objectMapper = new ObjectMapper();
        String user_str = objectMapper.writeValueAsString(user);
        System.out.println(user_str);
        return user_str;
    }
}
