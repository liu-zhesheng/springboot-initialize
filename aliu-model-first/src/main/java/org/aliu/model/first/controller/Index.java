package org.aliu.model.first.controller;

import org.aliu.model.first.domain.entity.Student;
import org.aliu.model.first.domain.enums.HttpStatusCodeEnum;
import org.aliu.model.first.domain.result.PageResponse;
import org.aliu.model.first.domain.result.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试返回格式controller
 *
 * @author liusheng
 * @date 2021/10/9
 */
@RestController
@RequestMapping("/api/index")
public class Index {

    /**
     * 操作成功
     *
     * @return
     */
    @GetMapping("/success")
    public ResponseResult success() {
        return ResponseResult.success();
    }


    /**
     * 带数据的成功
     *
     * @return
     */
    @GetMapping("/success/data")
    public ResponseResult successData() {
        Student student = new Student();
        student.setId(2L);
        student.setName("张三");
        return ResponseResult.success(student);
    }


    /**
     * 带列表数据的成功
     *
     * @return
     */
    @GetMapping("/success/list")
    public ResponseResult<Student> successList() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setId(1L);
        student.setName("小刘哥");
        students.add(student);
        return ResponseResult.success(HttpStatusCodeEnum.SUCCESS,students);
    }

    /**
     * 失败
     *
     * @return
     */
    @GetMapping("/fail")
    public ResponseResult fail() {
        return ResponseResult.fail();
    }

    /**
     * 失败枚举
     *
     * @return
     */
    @GetMapping("/fail/enum")
    public ResponseResult failEnum() {
        return ResponseResult.fail(HttpStatusCodeEnum.NEED_ADMIND);
    }

    /**
     * 分页失败
     *
     * @return
     */
    @GetMapping("/page/fail")
    public PageResponse<Student> page() {
        return PageResponse.fail(HttpStatusCodeEnum.DATA_NOT_EXIST);
    }


    @GetMapping("/page/success")
    public PageResponse<Student> pageData() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setId(1L);
        student.setName("小刘哥");
        students.add(student);
        return PageResponse.success(students, 4, HttpStatusCodeEnum.SUCCESS);
    }
}
