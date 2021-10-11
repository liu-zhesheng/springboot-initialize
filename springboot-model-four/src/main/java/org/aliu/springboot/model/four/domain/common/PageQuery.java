package org.aliu.springboot.model.four.domain.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用分页查询对象
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Data
public class PageQuery<T> implements Serializable {

    private static final long serialVersionUID = -7717520428315031630L;

    /**
     * 当前页
     */
    private Integer currentPage = 1;

    /**
     * 每页行数
     */
    private Integer pageSize = 20;

    /**
     * 查询条件
     */
    private T query;
}
