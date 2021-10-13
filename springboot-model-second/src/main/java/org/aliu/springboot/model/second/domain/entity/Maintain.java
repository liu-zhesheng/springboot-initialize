package org.aliu.springboot.model.second.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 保养记录 POJO
 *
 * <p>
 *     数据库字段与 POJO 属性自动映射
 *     1.名称一样,注解 {@link com.baomidou.mybatisplus.annotation.TableField}
 *     2.数据库字段使用 _ 分割,属性名使用驼峰命名
 * </p>
 *
 * @author liusheng
 * @date 2021/9/27
 */
@TableName
@Setter
@Getter
public class Maintain {

    /**
     * 保养记录 id
     */
    //设置 id 的自增策略   AUTO 为数据库自增  ASSIGN_ID 为雪花算法分布式id
    @TableId(type = IdType.AUTO)
    private Long maintainId;

    /**
     * 保养日期
     */
    private LocalDate maintainDate;

    /**
     * 保养里程
     */
    private Long maintainMileage;

    /**
     * 保养项目
     */
    private String maintainItems;

    /**
     * 保养车辆 Vin
     */
    private String vin;

    /**
     * 保养记录创建时间
     */
    private LocalDateTime createTime;
}
