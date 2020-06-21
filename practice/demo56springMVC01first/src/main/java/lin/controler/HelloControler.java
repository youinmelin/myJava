package lin.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controler Class
 */
@Controller
@RequestMapping("/user")
public class HelloControler {

    private int times=0;

    @RequestMapping(value = "/hello")
    public String sayHello() {
        System.out.println("hello SpringMVC");
        return "success";
    }

    @RequestMapping(value = "/testRM",
            method = {RequestMethod.GET},
            params = "username")
    public String testRequestMapping(String username) {
        times++;
        System.out.println(times);
        System.out.println("test @RequestMapping");
        System.out.println("username: " + username);
        return "success";
    }
}

