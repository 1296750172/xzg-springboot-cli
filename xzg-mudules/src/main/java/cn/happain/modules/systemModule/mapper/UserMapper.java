package cn.happain.modules.userModule.mapper;

import cn.happain.modules.userModule.model.UserModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author happain
 * @since 2023-01-26
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<UserModel> {

}
