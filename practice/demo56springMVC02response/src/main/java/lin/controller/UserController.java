package lin.controller;

import lin.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(ModelMap modelMap) {
        System.out.println("testString.");
        User user = new User();
        user.setUsername("String");
        user.setPassword("123");
        user.setAge(20);
        modelMap.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView");
        User user = new User();
        user.setUsername("ModelAndView");
        user.setPassword("123");
        user.setAge(20);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }
}
