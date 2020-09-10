package lin.fliter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  if access-token is not blank, filer can let program keep going
 *  to test:
 *  input:http://localhost:10010/user-consumer/consumer/1?access-token=1
 *  input:http://localhost:10010/user-consumer/consumer/1
 */
@Component
public class ZuulFilterToken extends ZuulFilter {
    @Override
    public String filterType() {
//        return "pre";
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
//        return 0;
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("access-token");
        if (StringUtils.isBlank(token)) {
            System.out.println("token is blank");
            // true: keep going; false: intercept
//            context.setSendZuulResponse(false);
            // set status code forbidden(403)
            context.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        System.out.println("token is not blank");
        return null;
    }
}
