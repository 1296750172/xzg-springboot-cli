package cn.happain.system.userModule.dto;

import cn.happain.common.dto.valid.BaseGroup;
import cn.happain.system.userModule.dto.valid.UserGroup;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @创建人 happain
 * @创建时间 2023/1/26
 * @描述
 */
@Data
@Accessors(chain = true)
public class UserDto {
    @NotBlank(message = "用户名不能为空",groups = {BaseGroup.login.class})
    private String username;
    @NotBlank(message = "密码不能为空",groups = {BaseGroup.login.class})
    private String password;
    @Email(message = "输入邮箱有误",groups = {UserGroup.getEmailCode.class})
    @NotBlank(message = "输入邮箱不能为空",groups = {UserGroup.getEmailCode.class})
    private String email;

    @Pattern(message = "输入手机号有误",regexp = "[1][34578]\\d{9}",groups = {UserGroup.getEmailCode.class})
    @NotBlank(message = "输入手机号不能为空",groups = {UserGroup.getEmailCode.class})
    private String phone;
    /**验证码*/
    private String code;

}
