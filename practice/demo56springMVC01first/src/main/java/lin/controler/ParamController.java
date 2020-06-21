package lin.controler;

import lin.domain.Account;
import lin.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/saveAccount")
    public String testParam(Account account) {
        System.out.println("username: " + account.getUsername());
        System.out.println("password: " + account.getPassword());
        System.out.println("money:"  + account.getMoney());
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println(user);
        return "success";
    }
}
