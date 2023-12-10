package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //@Component로 빈으로 등록하거나 SpringConfig에서 빈으로 등록
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            {
                long finish = System.currentTimeMillis();
                long timeMs = finish - start;
                System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
            }
        }
    }
}
