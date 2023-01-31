package cn.happain.system.permissionModule.service.impl;

import cn.happain.system.permissionModule.model.PermissionModel;
import cn.happain.system.permissionModule.mapper.PermissionMapper;
import cn.happain.system.permissionModule.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionModel> implements IPermissionService {

}
