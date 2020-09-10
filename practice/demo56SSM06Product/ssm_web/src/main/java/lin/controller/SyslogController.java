package lin.controller;

import lin.domain.Syslog;
import lin.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SyslogController {

    @Autowired
    ISyslogService syslogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllSyslog() {
        List<Syslog> syslogs = syslogService.findAllLog();
        for (Syslog log :
                syslogs) {
            System.out.println(log);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("sysLogs", syslogs);
//        mv.setViewName("loglist");
        mv.setViewName("syslog-list");
        return mv;
    }
}
