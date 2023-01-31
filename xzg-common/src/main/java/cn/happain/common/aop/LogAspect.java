package cn.happain.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @创建人 happain
 * @创建时间 2023/1/25
 * @描述 aop是先执行around - before -aroud -after
 */
@Component
@Aspect
@Slf4j
public class LogAspect {


    /** 注解切面*/
    @Pointcut("@annotation(cn.happain.common.annotation.LogAnno)")
    public void logAnno() {}

    /**在切点之前*/
    @Before("logAnno()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        log.info("========================================== Start ==========================================");
        // 打印请求 url
        log.info("url            : {}", request.getRequestURL().toString());
        // 打印调用 controller 的全路径以及执行方法
        log.info("类方法   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 请求参数
        log.info("请求参数: ");
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
    }
    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("logAnno()")
    public void doAfter() throws Throwable {
        // 接口结束后换行，方便分割查看
        log.info("=========================================== End ===========================================");
    }


    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("logAnno()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }
}
