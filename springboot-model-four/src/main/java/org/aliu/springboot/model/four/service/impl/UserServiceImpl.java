package org.aliu.springboot.model.four.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.aliu.springboot.model.four.domain.common.PageQuery;
import org.aliu.springboot.model.four.domain.common.PageResult;
import org.aliu.springboot.model.four.domain.dto.UserDTO;
import org.aliu.springboot.model.four.domain.dto.UserQueryDTO;
import org.aliu.springboot.model.four.domain.entity.UserDO;
import org.aliu.springboot.model.four.domain.vo.UserVO;
import org.aliu.springboot.model.four.mapper.UserMapper;
import org.aliu.springboot.model.four.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liusheng
 * @date 2021/9/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(UserDTO userDTO) {
        UserDO userDO = new UserDO();

        // TODO: 2021/10/11 浅拷贝 属性名相同才能拷贝
        BeanUtils.copyProperties(userDTO, userDO);
        return userMapper.insert(userDO);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int update(Long id, UserDTO userDTO) {
        UserDO userDO = new UserDO();

        BeanUtils.copyProperties(userDTO, userDO);

        return userMapper.updateById(userDO);
    }

    @Override
    public PageResult<List<UserDTO>> query(PageQuery<UserQueryDTO> pageQuery) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(pageQuery.getQuery(), userDO);
        // TODO: 2021/10/11 如果属性不一致,需要做特殊处理

        //参数构造
        Page page = new Page(pageQuery.getCurrentPage(),
                pageQuery.getPageSize());

        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        IPage userDOPage = userMapper.selectPage(page, wrapper);

        //结果解析
        PageResult pageResult = new PageResult();
        pageResult.setCurrentPage((int) userDOPage.getCurrent());
        pageResult.setPageSize((int) userDOPage.getSize());
        pageResult.setTotal(userDOPage.getTotal());
        pageResult.setTotalPage(userDOPage.getPages());

        List<UserDTO> userDTOList = Optional.ofNullable(userDOPage.getRecords())
                .map(List::stream)
                .orElseGet(Stream::empty)
                .map(DO -> {
                    UserDTO userDTO = new UserDTO();
                    BeanUtils.copyProperties(DO, userDTO);
                    return userDTO;
                })
                .collect(Collectors.toList());

        pageResult.setData(userDTOList);
        return pageResult;
    }
}
