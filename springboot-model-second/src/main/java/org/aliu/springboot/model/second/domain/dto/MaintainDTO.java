package org.aliu.springboot.model.second.domain.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import org.aliu.springboot.model.second.domain.entity.Maintain;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 保养记录 DTO
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Getter
public class MaintainDTO {

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
    private Long[] maintainItems;

    /**
     * 保养车辆 Vin
     */
    private String vin;

    /**
     * 保养记录创建时间
     */
    private LocalDateTime createTime;

    public Maintain of() {
        Maintain maintain = new Maintain();
        maintain.setMaintainDate(getMaintainDate());
        maintain.setMaintainMileage(getMaintainMileage());
        maintain.setMaintainItems(JSON.toJSONString(getMaintainItems()));
        maintain.setVin(getVin());
        maintain.setCreateTime(getCreateTime());
        return maintain;
    }
}
