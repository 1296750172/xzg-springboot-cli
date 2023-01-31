package cn.happain.common.consts;

/**
 * @创建人 happain
 * @创建时间 2023/1/25
 * @描述
 */
public class GlobalConst {

    /*用户模块*/
    public static class USER_MODULE {
        /*请求成功的默认返回消息*/
        public static final String SUCCESS_DEFAULT_MESSAGE = "success";

        public enum LOGIN_TYPE  {
            /*常规账号密码登陆*/
            DEFAULT,
            /*手机登陆*/
            PHONE,
            /*邮箱登陆*/
            EMAIL,
            /*微信公众号登陆*/
            WX_GZH
        }
    }
}

