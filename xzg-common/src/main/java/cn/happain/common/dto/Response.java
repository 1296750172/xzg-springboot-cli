package cn.happain.common.dto;

import cn.happain.common.consts.GlobalConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @创建人 happain
 * @创建时间 2023/1/25
 * @描述 请求响应封装
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Response<T> {
    private Integer code;
    private String message;
    private T data;


    /**默认成功请求*/
    public static <T> Response<T> successDefault() {
        return new Response<T>().setCode(200).setMessage(GlobalConst.USER_MODULE.SUCCESS_DEFAULT_MESSAGE);
    }

    /**自定义返回消息*/
    public static <T> Response<T> successMessage(String message) {
        return new Response<T>().setCode(200).setMessage(message);
    }

    /**自定义数据与消息*/
    public static <T> Response<T> successDataMessage(T data,String message) {
        return  new Response<T>().setCode(200).setMessage(message).setData(data);
    }
    /** 自定义数据*/
    public static <T> Response<T> successDataDefault(T data) {
        return  new Response<T>().setCode(200).setMessage(GlobalConst.USER_MODULE.SUCCESS_DEFAULT_MESSAGE).setData(data);
    }

    /** 自定义权限异常错误处理*/
    public static <T> Response<T> failPermission() {
        return  new Response<T>().setCode(403).setMessage("权限不足，请联系管理员");
    }

    /** 默认错误*/
    public static <T> Response<T> failDefault() {
        return  new Response<T>().setCode(404).setMessage("内部错误，请联系管理员");
    }

    /** 自定义消息错误*/
    public static <T> Response<T> failDefault(String message) {
        return  new Response<T>().setCode(404).setMessage(message);
    }





}
