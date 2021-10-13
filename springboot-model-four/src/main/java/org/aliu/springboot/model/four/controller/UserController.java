package org.aliu.springboot.model.four.controller;

import lombok.extern.slf4j.Slf4j;
import org.aliu.springboot.model.four.domain.common.PageQuery;
import org.aliu.springboot.model.four.domain.common.PageResult;
import org.aliu.springboot.model.four.domain.common.ResponseResult;
import org.aliu.springboot.model.four.domain.dto.UserDTO;
import org.aliu.springboot.model.four.domain.dto.UserQueryDTO;
import org.aliu.springboot.model.four.exception.ErrorCodeEnum;
import org.aliu.springboot.model.four.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户相关接口
 *
 * @author liusheng
 * @date 2021/9/27
 */
@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * <p>
     * POST /api/users   UserDTO
     */
    @PostMapping
    public ResponseResult save(@RequestBody UserDTO userDTO) {
        int save = userService.save(userDTO);

        if (save == 1) {
            return ResponseResult.success("新增成功");
        } else {
            return ResponseResult.fail(ErrorCodeEnum.INSERT_ERROR);
        }

    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        int delete = userService.delete(id);
        if (delete == 1) {
            return ResponseResult.success("删除成功");
        } else {
            return ResponseResult.fail(ErrorCodeEnum.DELETE_ERROR);
        }
    }


    /**
     * 更新用户信息
     * PUT  /api/users/{id}   UserDTO userDTO
     *
     * @return
     */
    @PutMapping("/{id}")
    public ResponseResult update(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        int update = userService.update(id, userDTO);

        if (update == 1) {
            return ResponseResult.success("更新成功");
        } else {
            return ResponseResult.fail(ErrorCodeEnum.UPDATE_ERROR);
        }
    }

    /**
     * 分页查询用户信息
     * <p>
     * GET  /api/users
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping
    public ResponseResult<PageResult> query(@RequestParam("currentPage") Integer currentPage,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestBody UserQueryDTO userQueryDTO) {
        PageQuery<UserQueryDTO> pageQuery = new PageQuery(currentPage, pageSize, userQueryDTO);
        PageResult<List<UserDTO>> queryResult = userService.query(pageQuery);

        return ResponseResult.success(queryResult,ErrorCodeEnum.SUCCESS);
    }

}
