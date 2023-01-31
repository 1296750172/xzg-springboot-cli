package cn.happain.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @创建人 happain
 * @创建时间 2023/1/26
 * @描述 全局工具类
 */
@Component
@Slf4j
public class GlobalUtil {

    public void exceptionLog(HttpServletRequest req) {
        log.error("请求路径：{}",req.getRequestURL());
        log.error("请求地址：{}",req.getRemoteAddr());
    }
}
