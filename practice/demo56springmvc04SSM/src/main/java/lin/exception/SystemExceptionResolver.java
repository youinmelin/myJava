package lin.exception;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SystemExceptionResolver implements HandlerExceptionResolver{
    /**
     * manage exception
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o 当前处理器对象
     * @param e 当前抛出的异常对象
     * @return
     */
    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {
        // get exception object
        SysException sysException = null;
        if (e instanceof SysException) {
            // 判断类型，如果是SystemException类型，将之强转
            sysException = (SysException) e;
            e.printStackTrace();
        }else if (e instanceof NestedServletException){
            sysException = new SysException("服务器异常，文件太大");
            e.printStackTrace();
        } else {
            sysException = new SysException("系统故障，请联系管理员");
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorInformation", sysException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
