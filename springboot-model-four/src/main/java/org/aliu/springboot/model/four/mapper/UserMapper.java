package org.aliu.springboot.model.four.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.aliu.springboot.model.four.domain.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liusheng
 * @date 2021/9/27
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    //如需自定义方法在这里添加
}
