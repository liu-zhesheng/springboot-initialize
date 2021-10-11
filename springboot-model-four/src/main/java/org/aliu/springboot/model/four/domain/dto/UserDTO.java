package org.aliu.springboot.model.four.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户DTO实体
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Data
public class UserDTO implements Serializable {


    private static final long serialVersionUID = 1613705366948068853L;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

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

    /**
     * 版本号,数据每一次修改都要累加版本号
     */
    private Long version;
}
