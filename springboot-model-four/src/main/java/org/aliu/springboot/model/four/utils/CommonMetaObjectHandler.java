package org.aliu.springboot.model.four.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 公共元数据处理器
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Slf4j
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入填充字段
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("新建时,开始填充系统字段");

        //填充创建时间
        this.strictInsertFill(metaObject,
                "created",
                LocalDateTime.class,
                LocalDateTime.now());

        //填充修改时间
        this.strictInsertFill(metaObject,
                "modified",
                LocalDateTime.class,
                LocalDateTime.now());

        //填充创建人
        this.strictInsertFill(metaObject,
                "creator",
                String.class,
                "从上下文中获取当前人");

        //填充操作人
        this.strictInsertFill(metaObject,
                "operator",
                String.class,
                "从上下文中获取当前人");

        //填充状态
        this.strictInsertFill(metaObject,
                "status",
                Integer.class,
                0);

        //填充版本号
        this.strictInsertFill(metaObject,
                "version",
                Long.class,
                1L);
    }

    /**
     * 修改填充字段
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,
                "operator",
                String.class,
                "从当前上下文获取");
    }
}
