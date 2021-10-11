package org.aliu.model.first.controller;

import org.aliu.model.first.domain.entity.Student;
import org.aliu.model.first.domain.enums.HttpStatusCodeEnum;
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
     * 成功
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
    public ResponseResult successData() {
        return ResponseResult.success(HttpStatusCodeEnum.SUCCESS);
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

        return ResponseResult.success(students);
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
}
