package org.aliu.springboot.model.four.service.impl;

import org.aliu.springboot.model.four.domain.dto.UserQueryDTO;
import org.aliu.springboot.model.four.service.ExcelExportService;
import org.aliu.springboot.model.four.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * Excel导出服务实现类
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Service
public class ExcelExportServiceImpl implements ExcelExportService {

    @Resource(name = "localFileServiceImpl")
    private FileService fileService;

    /**
     * 执行数据库查询和Excel导出,将数据写入到outputStream中
     *
     * @param outputStream
     * @param queryDTO
     */
    private void export(OutputStream outputStream, UserQueryDTO queryDTO) {

        //step1.需要创建一个EasyExcel导出对象

        //step2.分批加载数据

        //step3.导出分批加载数据

        //step4. 收尾
    }


    @Override
    public void export(UserQueryDTO dto, String filename) {

        //输出流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


        //step1 实现数据导出到Excel中
        export(outputStream, dto);

        //输入流
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        //step2 实现文件上传
    }
}
