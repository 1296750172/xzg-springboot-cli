package cn.happain.system.roleModule.service.impl;

import cn.happain.system.roleModule.model.RoleModel;
import cn.happain.system.roleModule.mapper.RoleMapper;
import cn.happain.system.roleModule.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author happain
 * @since 2023-01-27
 */
@Service
@Transactional
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleModel> implements IRoleService {

}
