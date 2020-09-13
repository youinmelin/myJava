package lin.controller;

import lin.domain.User;
import lin.exception.SysException;
import lin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAllUser(ModelAndView mv) {
        System.out.println("USL: UserController.findAll");
        List<User> users = userService.findAllUser();
        mv.addObject("users", users);
        mv.setViewName("show_users");
        return mv;
    }

    @RequestMapping("/setCookies")
    public ModelAndView setCookies(Integer uid, HttpServletRequest request, HttpServletResponse response) throws SysException {
        ModelAndView mv = new ModelAndView();
        if (uid == null) {
//            throw new SysException("<a href='/user/findAll'>尚未选择，请重新选择</a>");
            mv.addObject("errorInformation","<a href='/user/findAll'>尚未选择，请重新选择</a>");
            mv.setViewName("reselectUser");
            return mv;
        }
        User user = userService.findUserById(uid);
        String username = user.getUsername();

//        System.out.println("setCookie: " + username);
        Cookie cookieUid = new Cookie("uid", uid+"");
        cookieUid.setMaxAge(3600*30);
        cookieUid.setPath("/");
        response.addCookie(cookieUid);
//        System.out.println("set uid cookie:" + cookieUid.getValue());

        Cookie cookieUname = new Cookie("username", username);
        cookieUname.setMaxAge(3600*30);
        cookieUname.setPath("/");
        response.addCookie(cookieUname);
        System.out.println("set username cookie:" + cookieUname.getValue());

        Cookie cookieAuthority = new Cookie("authority", user.getAuthority());
        cookieAuthority.setMaxAge(3600*30);
        cookieAuthority.setPath("/");
        response.addCookie(cookieAuthority);
//        System.out.println("set authority cookie:" + cookieAuthority.getValue());
//    out.write("wellcom: " + username);
//        response.sendRedirect("index.jsp");
//        return "../../index";
        mv.setViewName("success");
        return mv;
    }
}
