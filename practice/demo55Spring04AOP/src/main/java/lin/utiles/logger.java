package lin.utiles;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * utility class to record log
 */
public class logger {
    /**
     * print log, execute before Pointcut前置通知
     */
    public void beforePrintLog() {
        System.out.println("beforePrintLog Logger Class printlog method.");
    }

    /**
     * after advice后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("afterReturningPringLog Logger Class printlog method.");
    }

    /**
     * exception advice异常通知
     */
    public void afterThrowingLog() {
        System.out.println("afterThrowingLog in Logger Class printlog method.");
    }

    /**
     * final advice最终通知
     */
    public void afterPrintLog() {
        System.out.println("afterPrintLog in  Logger Class printlog method.");
    }

    /**
     * 环绕通知
     */
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
