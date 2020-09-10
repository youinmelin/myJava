package lin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {

    /**
     * search cookie if uid is not null,then program can go on
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        String uid = null;
        if (cookies!=null && cookies.length>0) {
            for (Cookie cookie : cookies) {
//                System.out.println("cookie_name: " + cookie.getName());
                if ("uid".equals(cookie.getName())) {
                    uid = cookie.getValue();
//                    uid = Integer.parseInt(cookie.getValue());
                    System.out.println("interceptor: " + uid + " already login");
//                    System.out.println("getValue: " + cookie.getValue());
                    return true;
                    }
                }
        }
        if (uid == null) {
            System.out.println("interceptor: not login");
            response.sendRedirect("/user/findAll");
            return false;
        }
        return true;
    }
}
