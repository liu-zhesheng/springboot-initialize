package org.aliu.springboot.model.second.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 排名 POJO
 *
 * @author liusheng
 * @date 2021/9/27
 */
@TableName
@Setter
@Getter
public class Rank {

    /**
     * 排名 id
     */
    private Long rankId;

    /**
     * 排名
     */
    private Integer rankRank;

    /**
     * 得分
     */
    private String rankScore;

    /**
     * 车辆Vin
     */
    private String rankVin;
}
