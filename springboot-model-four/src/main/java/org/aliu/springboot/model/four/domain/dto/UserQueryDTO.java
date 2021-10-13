package org.aliu.springboot.model.four.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页参数DTO
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Data
public class UserQueryDTO implements Serializable {


    private static final long serialVersionUID = 3033532065421245483L;


    /**
     * 用户姓名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号码
     */
    private String phone;

}
