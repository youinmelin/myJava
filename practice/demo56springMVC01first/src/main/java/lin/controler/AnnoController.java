package lin.controler;

import lin.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

@Controller
@RequestMapping("/anno")
@SessionAttributes({"msg"})  // save meg in session
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String name) {
        System.out.println("testRequestParam");
        System.out.println(name);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBdoy(@RequestBody String body) {
        System.out.println("testRequestBody");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{pid}")
    public String testPathVariable(@PathVariable("pid") String id) {
        System.out.println("testPathVariable");
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie) {
        System.out.println("testCookieValue");
        System.out.println(cookie);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("testModelAttribute");
        System.out.println(user);

        return "success";
    }

    /**
     * 该方法会在其他方法执行之前最先执行,也就最先获取客户请求数据
     */
    @ModelAttribute
    public User init() {
        System.out.println("initializing...");
        User user= new User();
        user.setName("no_name");
        user.setAge(0);
        user.setDate(new Date());
        return user;

    }

    @RequestMapping("/testSetSessionAttributes")
    public String testSessionAttributes(ModelMap model) {
        System.out.println("testSessionAttributes");
        // save msg to request
        model.addAttribute("msg", "all right");
        return "success";
    }

    @RequestMapping("/testGetSessionAttributes")
    public String testGetSessionAttribute(ModelMap modelMap) {
        String msg = (String)modelMap.get("msg");
        // get msg from request
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/testDelSessionAttributes")
    public String testDelSessionAttributes(SessionStatus sessionStatus) {
        System.out.println("DelSessionAttributes");
        // del session
        sessionStatus.setComplete();
        return "success";
    }
}
