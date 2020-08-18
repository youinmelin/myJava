package lin.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.debug("MyInterceptor class, preHanlder method");
        System.out.println("MyInterceptor class, preHanlder method");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        log.debug("MyInterceptor class, postHandle method");
        System.out.println("MyInterceptor class, postHanlder method");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        log.debug("MyInterceptor class, afterCompletion method");
        System.out.println("MyInterceptor class, afterCompletion method");

    }
}
