package org.aliu.model.first.domain.result;

/**
 * 分页统一返回格式
 *
 * @author liusheng
 * @date 2021/10/9
 */
public class PageResponse extends ResponseResult {

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 当前页大小
     */
    private Integer size;

    /**
     * 总条数
     */
    private Integer total;


    public PageResponse(Integer code, String message, Object data, Boolean success, Integer currentPage) {
        super(code, message, data, success);
        this.currentPage = currentPage;
    }
}
