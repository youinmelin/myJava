package lin.utiles;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * utility class to record log
 */


@Component("logger")
@Aspect//表示当前类是一个切面类
public class logger {
    //配置切入点表达式
    @Pointcut("execution(* lin.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * print log, execute before Pointcut前置通知
     * @Before()与test中的before不同，要导入的包也不一样
     */
//    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("beforePrintLog Logger Class printlog method.");
    }

    /**
     * after advice后置通知
     */
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("afterReturningPringLog Logger Class printlog method.");
    }

    /**
     * exception advice异常通知
     */
//    @AfterThrowing("pt1()")
    public void afterThrowingLog() {
        System.out.println("afterThrowingLog in Logger Class printlog method.");
    }

    /**
     * final advice最终通知
     */
//    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("afterPrintLog in  Logger Class printlog method.");
    }

    /**
     * 环绕通知
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println("before by aroundPrintLog in Logger Class printLog method.");
            rtValue = pjp.proceed(args);
            System.out.println("after-returning by aroundPrintLog in Logger Class printLog method.");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("after-throwing by aroundPrintLog in Logger Class printLog method.");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("after by aroundPrintLog in Logger Class printLog method.");
        }
    }
}
