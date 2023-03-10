package cn.happain.system.userModule.service.impl;

import cn.happain.common.dto.Response;
import cn.happain.common.service.EmailService;
import cn.happain.common.service.RedisService;
import cn.happain.system.userModule.dto.UserDto;
import cn.happain.system.userModule.mapper.UserMapper;
import cn.happain.system.userModule.model.UserModel;
import cn.happain.system.userModule.service.IUserService;
import cn.happain.system.userModule.vo.UserLoginVo;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @author happain
 * @since 2023-01-26
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements IUserService {

    @Resource
    private EmailService emailService;
    @Resource
    private RedisService redisService;

    public Response<UserLoginVo> login(UserDto userDto) {
        LambdaQueryWrapper<UserModel> queryWrapper = new QueryWrapper<UserModel>().lambda();
        queryWrapper.eq(UserModel::getUsername,userDto.getUsername())
                .eq(UserModel::getPassword,userDto.getPassword());
        UserModel userModel = this.baseMapper.selectOne(queryWrapper);
        if(userModel!=null) {
            /*查找对应的角色和权限*/
            
        }else {
            return Response.failDefault("用户名或密码错误");
        }

        return Response.successDataDefault(null);
    }


    /**
     * 获得电子邮件代码
     *
     * @param userDto 用户dto
     * @return {@link Response}
     * @throws MessagingException 通讯异常
     */
    public Response getEmailCode(UserDto userDto) throws MessagingException {
        emailService.sendSimple(userDto.getEmail(),null,"登陆验证码",RandomUtil.randomString(4));
        return Response.successDefault();
    }
}
