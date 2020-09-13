package lin.controller;

import lin.domain.Syslog;
import lin.service.ISyslogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;

@Component
@Aspect  // 标识切片类
public class LogAop {

    @Autowired
    private HttpServletRequest request;  // 获取request对象，需要现在web.xml中配置RequestContextListener listener
    @Autowired
    ISyslogService syslogService;

    private Date visitTime;
    private Class clazz;  // 访问的类
    private Method method;  // 访问的方法

    // 前置通知， 获取开始时间，访问的类和方法 拦截controller下的所有类所有方法
    @Before("execution(* lin.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = joinPoint.getTarget().getClass(); // 获取访问的类对象
        String methodName = joinPoint.getSignature().getName(); // get method name
        Object[] args = joinPoint.getArgs();// 获取访问的方法的参数
        if ( args == null || args.length == 0) {  // 如果没有参数
            // 获取具体执行方法的method对象
            method = clazz.getMethod(methodName);  //只能获取无参数的方法
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                try {
                    classArgs[i] = args[i].getClass(); // 获取每一个参数的class，放入class数组中
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            clazz.getMethod(methodName, classArgs);
        }
    }

    // 前置通知，拦截controller下的所有类所有方法
    @After("execution(* lin.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        Long timeDuring = new Date().getTime() - visitTime.getTime();

        // get url (but not LogAop) ,by using reflect get annotation
        String url = "";
        if (clazz != null && method != null && clazz != LogAop.class) {
            // get annotation upon the class
            Annotation annotation = clazz.getAnnotation(RequestMapping.class);
            RequestMapping classAnnotation = (RequestMapping)annotation;
            if (classAnnotation != null) {
                String[] classValues = classAnnotation.value();// get values in the annotation
                // get annotation upon the method
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValues = methodAnnotation.value();
                    url = classValues[0] + methodValues[0];


                    // get ip address
                    String ip = request.getRemoteAddr();

                    // get username approach one using security
                    SecurityContext securityContext = SecurityContextHolder.getContext(); // 从上下文中获取当前登录用户
                    User user = (User) securityContext.getAuthentication().getPrincipal(); //获取spring security 中的user对象
                    String username = user.getUsername();
                    // get username another approach using request
                    SecurityContext security_context = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                    user = (User) security_context.getAuthentication().getPrincipal();
                    username = user.getUsername();

                    Syslog syslog = new Syslog();
                    syslog.setExecutionDuring(timeDuring);
                    syslog.setIp(ip);
                    syslog.setUrl(url);
                    syslog.setUsername(username);
                    syslog.setVisitTime(new Date());
                    syslog.setMethod("[Class] " + clazz.getName() + ", [Method] " + method.getName());

                    // save syslog object into database
                    syslogService.saveSyslog(syslog);
                }
            }
        }


    }
}
