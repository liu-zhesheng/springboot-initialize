package org.aliu.springboot.model.second.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 保养项目 POJO
 *
 * @author liusheng
 * @date 2021/9/27
 */
@TableName
@Getter
@Setter
public class MaintainItem {

    /**
     * 保养项目 id
     */
    private Long maintainItemId;

    /**
     * 保养项目名称
     */
    private String maintainItemName;

}
