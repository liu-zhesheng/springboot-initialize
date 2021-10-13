package org.aliu.springboot.model.four.service;

import org.aliu.springboot.model.four.domain.dto.UserQueryDTO;

/**
 * Excel导出服务接口
 *
 * @author liusheng
 * @date 2021/9/27
 */
public interface ExcelExportService {

    /**
     * 导出服务
     * @param dto
     * @param filename
     */
    void export(UserQueryDTO dto,String filename);
}
