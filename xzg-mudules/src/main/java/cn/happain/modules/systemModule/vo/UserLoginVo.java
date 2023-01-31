package cn.happain.modules.userModule.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @创建人 happain
 * @创建时间 2023/1/26
 * @描述
 */

@Data
@Accessors(chain = true)
public class UserLoginVo {
    private String username;
    private String token;
    private String demo;
}
