package lin.utiles;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class transterUtiles {

    @Pointcut("execution(* lin.service.impl.AccountServiceImpl.transfer(..))")
    private void pt2(){}

    @Around("pt2()")
    public void aroundAspect(ProceedingJoinPoint pjp) {
        Object retValue = null;
        try{
            Object[] args = pjp.getArgs();
            System.out.println("operation beginning...");
            retValue = pjp.proceed(args);
            System.out.println("operation succeed...");
        } catch (Throwable throwable) {
            System.out.println("operation failed... call back");
            throwable.printStackTrace();
        }finally {
            System.out.println("operation done...");
        }

    }


}
