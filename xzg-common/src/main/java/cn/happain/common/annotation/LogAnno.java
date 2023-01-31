package cn.happain.common.annotation;

import java.lang.annotation.*;

/**
  * @创建人 happain
  * @创建时间  2023/1/25
  * @描述 日志注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnno {

    String description() default "";
}
