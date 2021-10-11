package org.aliu.model.first.domain.result;

import org.aliu.model.first.domain.enums.HttpStatusCodeEnum;

import java.util.List;

/**
 * 分页统一返回格式
 *
 * @author liusheng
 * @date 2021/10/9
 */
public class PageResponse<T> {

    /**
     * 返回状态码
     */
    private final Integer code;

    /**
     * 返回信息
     */
    private final String message;

    /**
     * 返回数据
     */
    private final List<T> data;

    /**
     * 是否成功
     */
    private final Boolean success;


    /**
     * 总条数
     */
    private final Integer total;

    public PageResponse(Integer code, String message, List<T> data, Boolean success, Integer total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;

        this.total = total;
    }


    public Integer getTotal() {
        return total;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<T> getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public static <T> Builder<T> builder() {
        return new PageResponse.Builder<>();
    }

    public static <T> PageResponse<T> fail() {
        Builder<T> builder = builder();
        return builder.code(400).message("操作失败").success(Boolean.FALSE).build();
    }

    public static <T> PageResponse<T> fail(HttpStatusCodeEnum codeEnum) {
        Builder<T> builder = builder();
        return builder.code(codeEnum.getCode()).message(codeEnum.getMessage()).success(Boolean.FALSE).build();
    }

    public static <T> PageResponse<T> success() {
        Builder<T> builder = builder();
        return builder.code(200).message("操作成功").success(Boolean.TRUE).build();
    }

    public static <T> PageResponse<T> success(HttpStatusCodeEnum codeEnum) {
        Builder<T> builder = builder();
        return builder.code(codeEnum.getCode()).message(codeEnum.getMessage()).success(Boolean.TRUE).build();
    }

    public static <T> PageResponse<T> success(List<T> data, Integer total, HttpStatusCodeEnum codeEnum) {
        Builder<T> builder = builder();
        return builder.code(codeEnum.getCode()).message(codeEnum.getMessage()).success(Boolean.TRUE).data(data).total(total).build();
    }

    private static class Builder<T> {
        private Integer code;
        private String message;
        private List<T> data;
        private Boolean success;
        private Integer currentPage;
        private Integer size;
        private Integer total;

        public Builder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(List<T> data) {
            this.data = data;
            return this;
        }

        public Builder<T> success(Boolean success) {
            this.success = success;
            return this;
        }

        public Builder<T> currentPage(Integer currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        public Builder<T> size(Integer size) {
            this.size = size;
            return this;
        }

        public Builder<T> total(Integer total) {
            this.total = total;
            return this;
        }

        public PageResponse<T> build() {
            return new PageResponse<>(code, message, data, success,total);
        }
    }

}
