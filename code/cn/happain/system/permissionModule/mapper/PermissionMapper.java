package cn.happain.system.permissionModule.mapper;

import cn.happain.system.permissionModule.model.PermissionModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author happain
 * @since 2023-01-27
 */
@Mapper
@Component
public interface PermissionMapper extends BaseMapper<PermissionModel> {

}
