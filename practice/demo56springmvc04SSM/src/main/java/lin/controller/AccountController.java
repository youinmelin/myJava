package lin.controller;

import lin.domain.Account;
import lin.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * USL: account
 */
@Controller
@RequestMapping("/account")
public class AccountController {


    @Autowired
    IAccountService accountService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView mv) {
        System.out.println("USL: findAllAccount");
        List<Account> list = accountService.findAllAccount();
        mv.addObject("accounts", list);
        mv.setViewName("success");
        for (Account account :
                list) {
            System.out.println(account);
        }
        return mv;
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("USL: findAllAccount");
        accountService.saveAccount(account);
        try {
            response.sendRedirect(request.getContextPath() + "/account/findAll");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";

    }

}
