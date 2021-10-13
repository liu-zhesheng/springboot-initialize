package org.aliu.springboot.model.four.domain.dto;

import lombok.Data;
import org.aliu.springboot.model.four.utils.InsertValidationGroup;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "用户名不能为空",
            groups = {InsertValidationGroup.class})
    private String username;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空",
            groups = {InsertValidationGroup.class})
    @Email(message = "必须为有效的邮箱格式")
    private String email;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空",
            groups = {InsertValidationGroup.class})
    @Max(value = 60, message = "年龄不能大于60")
    @Min(value = 18, message = "年龄不能小于18")
    private Integer age;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空",
            groups = {InsertValidationGroup.class})
    private String phone;

}
