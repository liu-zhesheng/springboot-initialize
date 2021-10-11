package org.aliu.model.first.controller;

import org.aliu.model.first.domain.entity.Student;
import org.aliu.model.first.domain.enums.HttpStatusCodeEnum;
import org.aliu.model.first.domain.result.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生接口
 *
 * @author liusheng
 * @date 2021/10/11
 */
@RestController
@RequestMapping("/api/student")
public class StudnetController {

    static List<Student> students = null;


    static {
        students = new ArrayList<>();
        Student one = new Student();
        one.setId(1L);
        one.setName("张三");

        Student two = new Student();
        two.setId(2L);
        two.setName("李四");
        students.add(one);
        students.add(two);
    }

    /**
     * 根据 id 查找学生
     *
     * @param id
     * @return
     */
    @GetMapping("/selectStudent/{id}")
    public ResponseResult<Student> selectStudent(@PathVariable("id") Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)){
                return ResponseResult.success(student);
            }
        }
        return ResponseResult.fail(HttpStatusCodeEnum.DATA_NOT_EXIST);
    }

    /**
     * 查找所有学生
     *
     * @return
     */
    @GetMapping("/selectAllStudent")
    public ResponseResult<Student> selectAllStudent() {
        return ResponseResult.success(students);
    }

    /**
     * 新增学生
     *
     * @return
     */
    @PostMapping("/insertStudent")
    public ResponseResult<Void> insertStudent(@RequestBody Student student) {
        students.add(student);
        return ResponseResult.success(HttpStatusCodeEnum.SUCCESS);
    }

}
