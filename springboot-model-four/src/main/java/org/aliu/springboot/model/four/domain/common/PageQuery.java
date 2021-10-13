package org.aliu.springboot.model.four.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 通用分页查询对象
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Data
@AllArgsConstructor
public class PageQuery<T> implements Serializable {

    private static final long serialVersionUID = -7717520428315031630L;

    /**
     * 当前页
     */
    @NotNull(message = "页号不能为空")
    @Min(value = 1,message = "页号必须为正数")
    private Integer currentPage = 1;

    /**
     * 每页行数
     */
    @NotNull(message = "每页条数不能为空")
    @Max(value = 100,message = "每页条数不能超过100条")
    @Min(value = 1,message = "每条页数必须大于0")
    private Integer pageSize = 20;

    /**
     * 查询条件
     * 级联验证
     */
    @Valid
    @NotNull(message = "查询条件不能为空")
    private T query;
}
