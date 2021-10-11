package org.aliu.springboot.model.four.service;

import org.aliu.springboot.model.four.domain.common.PageQuery;
import org.aliu.springboot.model.four.domain.common.PageResult;
import org.aliu.springboot.model.four.domain.dto.UserDTO;
import org.aliu.springboot.model.four.domain.dto.UserQueryDTO;
import org.aliu.springboot.model.four.domain.vo.UserVO;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author liusheng
 * @date 2021/9/27
 */
public interface UserService {

    int save(UserDTO userDTO);

    int delete(Long id);

    int update(Long id, UserDTO userDTO);

    /**
     * 分页查询
     * @param pageQuery
     * @return
     */
    PageResult<List<UserDTO>> query(PageQuery<UserQueryDTO> pageQuery);
}
