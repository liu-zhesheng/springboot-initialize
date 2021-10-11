package org.aliu.model.first.domain.entity;


/**
 * 学生 POJO 类
 *
 * @author liusheng
 * @date 2021/10/9
 */
public class Student {

    /**
     * 学生id
     */
    private Long id;

    /**
     * 学生姓名
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
