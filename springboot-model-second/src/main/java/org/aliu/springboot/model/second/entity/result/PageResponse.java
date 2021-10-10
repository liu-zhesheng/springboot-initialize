package org.aliu.springboot.model.second.entity.result;

import lombok.Builder;
import lombok.Getter;
import org.aliu.springboot.model.second.entity.enums.HttpStatusCodeEnum;

import java.util.List;

/**
 * 分页统一格式
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Builder
@Getter
public class PageResponse<T> {

    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    /**
     * 数据
     */
    private final List<T> data;

    /**
     * 成功状态
     */
    private final boolean success;

    /**
     * 总条数
     */
    private final Long total;

    /**
     * 失败
     *
     * @return
     */
    public static PageResponse fail() {
        PageResponseBuilder<Object> builder = new PageResponseBuilder<>();
        return builder.code(400).message("操作失败").success(Boolean.FALSE).build();
    }
    public static PageResponse fail(HttpStatusCodeEnum codeEnum) {
        PageResponseBuilder<Object> builder = new PageResponseBuilder<>();
        return builder.code(codeEnum.getCode()).message(codeEnum.getMessage()).success(Boolean.FALSE).build();
    }

    /**
     * 成功
     *
     * @return
     */
    public static <T> PageResponse success(List<T> data, Long total) {
        PageResponseBuilder<T> builder = new PageResponseBuilder<T>();
        return builder.code(200).message("操作成功").data(data).success(Boolean.TRUE).total(total).build();
    }
}
