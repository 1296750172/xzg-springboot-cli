package cn.happain.system.userModule.controller;

import cn.happain.common.dto.Response;
import cn.happain.common.dto.valid.BaseGroup;
import cn.happain.system.userModule.dto.UserDto;
import cn.happain.system.userModule.dto.valid.UserGroup;
import cn.happain.system.userModule.service.impl.UserServiceImpl;
import cn.happain.system.userModule.vo.UserLoginVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @author happain
 * @since 2023-01-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    /**
     * 登录
     *
     * @param UserDto 用户dto
     * @return {@link Response}<{@link UserLoginVo}>
     */
    @PostMapping("/login")
    public Response<UserLoginVo> login(@Validated({BaseGroup.login.class}) @RequestBody UserDto UserDto) {
        return userService.login(UserDto);
    }

    /**
     * 获得电子邮件代码
     *
     * @param userDto 用户dto
     * @return {@link Response}
     * @throws MessagingException 通讯异常
     */
    @PostMapping("/getEmailCode")
    public Response getEmailCode(@Validated({UserGroup.getEmailCode.class}) @RequestBody UserDto userDto) throws MessagingException {
        return userService.getEmailCode(userDto);
    }





}
