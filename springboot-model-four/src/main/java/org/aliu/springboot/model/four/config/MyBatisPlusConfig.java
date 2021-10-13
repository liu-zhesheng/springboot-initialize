package org.aliu.springboot.model.four.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis Plus 配置类
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfig {


    /**
     * 分页插件配置
     *
     * 3.4.0之前使用 paginationInterceptor
     * 3.4.0之后使用 MyBatisPlusInterceptor
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 乐观锁配置
     * 1.如果更新数据中不带有version字段:不使用乐观锁,并且version不会累加
     * 2.如果更新字段中带有version,但与数据库中不一致,更新失败
     * 3.如果带有version,并且与数据库中一致,更新成功,并且version会累加
     *
     * @return
     */
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }

    /**
     * 逻辑删除配置
     */


    /**
     * 系统字段自动设置
     */


}
