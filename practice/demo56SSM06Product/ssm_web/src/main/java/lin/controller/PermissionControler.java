package lin.controller;

import lin.domain.Permission;
import lin.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionControler {

    @Autowired
    IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllPermission() {
        List<Permission> permissionList = permissionService.findAllPermission();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList", permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String savePermission(Permission permission) {
        permissionService.savePermission(permission);
        return "redirect:findAll.do";
    }
}
