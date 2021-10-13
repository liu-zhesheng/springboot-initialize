package org.aliu.springboot.model.four.domain.dto;

import lombok.Data;
import org.aliu.springboot.model.four.utils.InsertValidationGroup;
import org.aliu.springboot.model.four.utils.UpdateValidationGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "用户名不能为空",
            groups = {InsertValidationGroup.class})
    private String username;

    /**
     * 用户密码
     */
    @NotBlank(message = "密码不能为空",
            groups = {InsertValidationGroup.class})
    @Length(max = 18, min = 6, message = "密码长度不能少于6位,不能多于18位")  //非空时校验
    private String password;

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

    /**
     * 版本号,数据每一次修改都要累加版本号
     */
    @NotNull(message = "版本号不能为空",
            groups = {UpdateValidationGroup.class})
    private Long version;
}
