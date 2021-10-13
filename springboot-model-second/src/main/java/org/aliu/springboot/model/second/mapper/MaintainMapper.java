package org.aliu.springboot.model.second.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.aliu.springboot.model.second.domain.entity.Maintain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 保养记录
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Mapper
public interface MaintainMapper extends BaseMapper<Maintain> {
    /**
     * 根据id查找
     * @param id
     * @return
     */
    Maintain select(@Param("id") Long id);
}
