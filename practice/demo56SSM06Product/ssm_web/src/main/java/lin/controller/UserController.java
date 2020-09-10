package lin.controller;

import lin.domain.UserInfo;
import lin.domain.Role;
import lin.service.IRoleService;
import lin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;

    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ModelAndView findAllUser() {
        List<UserInfo> users = userService.findAllUser();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findUserDetailByUid(Integer uId) throws Exception {
        UserInfo user = userService.findUserWithRoleByUserId(uId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user-detail");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveUser(UserInfo userInfo) throws Exception {
        userService.insertUser(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView addRoleToUserByUId(Integer uid) {

        UserInfo userInfo = userService.findUserByUId(uid);
        List<Role> roles = roleService.findRolesByUIdWhichNotHave(uid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList",roles);
        mv.addObject("user",userInfo);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(Integer userId, Integer[] ids) {
        System.out.println("USL: add role to user.");
        System.out.println("user id: " + userId);
        for (Integer rId : ids) {
            System.out.println("role id: " + rId);
            userService.addRoleToUser(userId, rId);
        }
        return "redirect:findAll.do";

    }
}
