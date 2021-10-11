package org.aliu.springboot.model.four.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户VO实体
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Data
public class UserVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1461214666995423958L;


    /*** 用户主信息 ***/

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
