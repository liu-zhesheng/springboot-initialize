package org.aliu.springboot.model.four.utils;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 校验 DTO 工具类
 *
 * @author liusheng
 * @date 2021/10/13
 */
public class ValidatorUtils {

    /**
     * 构造全局校验器
     */
    private static Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 将传入的数据以及分组进行校验
     *
     * @param object
     * @param groups
     * @param <T>
     */
    public static <T> void validate(T object, Class... groups) {
        Set<ConstraintViolation<T>> validate =
                validator.validate(object, groups);
        if (!CollectionUtils.isEmpty(validate)) {
            String errors = validate.stream()
                    .map(c -> c.getPropertyPath() + Constant.COLON + c.getMessage())
                    .collect(Collectors.joining(Constant.ERROR_SEPARATOR));
            throw new RuntimeException(errors);
        }
    }
}
