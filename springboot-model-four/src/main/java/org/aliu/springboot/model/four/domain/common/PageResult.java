package org.aliu.springboot.model.four.domain.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页返回实体
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Data
public class PageResult<T> implements Serializable {


    private static final long serialVersionUID = -1379579045204310867L;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页行数
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 总页数
     */
    private Long totalPage;

    /**
     * 数据信息
     */
    private T data;

}
