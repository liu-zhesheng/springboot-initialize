package org.aliu.springboot.model.second.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.aliu.springboot.model.second.domain.dto.MaintainDTO;
import org.aliu.springboot.model.second.domain.enums.HttpStatusCodeEnum;
import org.aliu.springboot.model.second.domain.entity.Maintain;
import org.aliu.springboot.model.second.domain.result.PageResponse;
import org.aliu.springboot.model.second.domain.result.Response;
import org.aliu.springboot.model.second.mapper.MaintainMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * 保养记录相关接口
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Slf4j
@RestController
@RequestMapping("/api/maintain")
public class MaintainController {

    private final MaintainMapper maintainMapper;

    public MaintainController(MaintainMapper maintainMapper) {
        this.maintainMapper = maintainMapper;
    }

    /**
     * 增加
     *
     * @param dto
     * @return
     */
    @PostMapping("/addMaintain")
    public Response<Void> addMaintain(@RequestBody MaintainDTO dto) {
        Maintain maintain = dto.of();
        //添加之前执行查询操作看是否存在 , 存在执行修改,不存在执行添加
        maintainMapper.insert(maintain);
        return Response.success(null, HttpStatusCodeEnum.SUCCESS);
    }


    /**
     * 根据 id 删除
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteMaintainById/{id}")
    public Response<Void> deleteMaintainById(@PathVariable("id") Long id) {
        int result = maintainMapper.deleteById(id);
        return Response.success(null, HttpStatusCodeEnum.SUCCESS);
    }


    /**
     * 根据 map 构造条件删除
     *
     * @return
     */
    @PostMapping("/deleteMaintainByMap")
    public Response<Void> deleteMaintainByMap(@RequestBody MaintainDTO dto) {
        Map map = new HashMap<>();
        map.put("vin", dto.getVin());
        int result = maintainMapper.deleteByMap(map);
        return Response.success(null, HttpStatusCodeEnum.SUCCESS);
    }


    /**
     * 查询所有保养记录
     *
     * @return
     */
    @GetMapping("/getAllMaintain")
    public Response getAllMaintain() {
        if (CollectionUtils.isEmpty(maintainMapper.selectList(new QueryWrapper<Maintain>()))) {
            log.info("response: {}", JSON.toJSONString(Response.fail(HttpStatusCodeEnum.DATA_NOT_EXIST)), true);
            return Response.fail(HttpStatusCodeEnum.DATA_NOT_EXIST);
        }
        return Response.success(maintainMapper.selectList(new QueryWrapper<Maintain>()), HttpStatusCodeEnum.SUCCESS);
    }

    /**
     * 根据 id 查询保养记录
     *
     * @param id
     * @return
     */
    @GetMapping("/getMaintainById/{id}")
    public Response<Maintain> getMaintainById(@PathVariable("id") Long id) {
        Maintain maintain = maintainMapper.selectById(id);
        return Optional.ofNullable(maintain).map(maintain1 -> Response.success(maintain1, HttpStatusCodeEnum.SUCCESS))
                .orElse(Response.fail(HttpStatusCodeEnum.DATA_NOT_EXIST));
    }


    /**
     * 根据 vin 查询保养记录
     * <p>
     * lambdaQueryWrapper 构造条件
     * </p>
     *
     * @param vin
     * @return
     */
    @GetMapping("getMaintainByVin/{vin}")
    public Response<Maintain> getMaintainByVin(@PathVariable("vin") String vin) {
        if (CollectionUtils.isEmpty(maintainMapper.selectList(new LambdaQueryWrapper<Maintain>().eq(Maintain::getVin, vin)))) {
            return Response.fail(HttpStatusCodeEnum.DATA_NOT_EXIST);
        }
        return Response.success(maintainMapper.selectList(new LambdaQueryWrapper<Maintain>().eq(Maintain::getVin, vin)), HttpStatusCodeEnum.SUCCESS);
    }


    /**
     * 分页查询
     *
     * @param currentPage
     * @param size
     * @return
     */
    @GetMapping("/pageMaintain")
    public PageResponse<Maintain> getPageMaintain(@RequestParam("currentPage") Integer currentPage,
                                                  @RequestParam("size") Integer size) {
        Page<Maintain> maintainIPage = new Page<>(currentPage, size);
        Page<Maintain> page = maintainMapper.selectPage(maintainIPage, new QueryWrapper<>());
        if (CollectionUtils.isEmpty(page.getRecords())) {
            PageResponse.fail(HttpStatusCodeEnum.DATA_NOT_EXIST);
        }
        log.info("总条数: {}", page.getTotal());
        return PageResponse.success(page.getRecords(), page.getTotal(), HttpStatusCodeEnum.SUCCESS);
    }
}
