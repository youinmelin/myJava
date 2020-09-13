package lin.controller;

import lin.domain.Role;
import lin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllRoles() {
        List<Role> roles = roleService.findAllRoles();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/saveRole.do")
    public String saveRole(Role role) {
        roleService.saveRole(role);
        return "redirect:findAll.do";
    }
}
