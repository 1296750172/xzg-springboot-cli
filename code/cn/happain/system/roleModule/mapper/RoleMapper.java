package cn.happain.system.roleModule.mapper;

import cn.happain.system.roleModule.model.RoleModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author happain
 * @since 2023-01-27
 */
@Mapper
@Component
public interface RoleMapper extends BaseMapper<RoleModel> {

}
