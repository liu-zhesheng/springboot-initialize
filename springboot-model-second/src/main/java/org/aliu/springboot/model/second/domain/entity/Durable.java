package org.aliu.springboot.model.second.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 耐久度 POJO
 *
 * @author liusheng
 * @date 2021/9/27
 */
@TableName
@Setter
@Getter
public class Durable {

    /**
     * 耐久 id
     */
    private Long partDurableId;

    /**
     * 耐久名称
     */
    private String partDurableName;

    /**
     * 耐久度
     */
    private String partDurableScore;

    /**
     * 耐久vin
     */
    private String partDurableVin;

}
