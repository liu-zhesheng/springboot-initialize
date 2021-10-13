package org.aliu.springboot.model.four.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aliu.springboot.model.four.exception.ErrorCodeEnum;
import org.aliu.springboot.model.four.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 本地文件上传服务
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Slf4j
@Service
public class LocalFileServiceImpl implements FileService {


    /**
     * 存储空间
     */
    private static final String BUCKET = "upload";


    @Override
    public void upload(InputStream inputStream, String fileName) {
        //拼接文件的存储路径
        String storagePath = BUCKET + "/" + fileName;
        try (
                // JDK8 TWR 不能关闭外部资源
                InputStream innerInputStream = inputStream;
                FileOutputStream outputStream = new FileOutputStream(new File(storagePath));
        ) {
            //拷贝缓冲区
            byte[] buffer = new byte[1024];
            //读取文件流长度
            int len;
            //循环读取inputStream中数据写入到outputStream
            while ((len = innerInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(ErrorCodeEnum.FILE_UPLOAD_ERROR.getMessage());
        }
    }

    @Override
    public void upload(File file) {
        try {
            upload(new FileInputStream(file), file.getName());
        } catch (Exception e) {
            log.error("文件上传失败");
            throw new RuntimeException(ErrorCodeEnum.FILE_UPLOAD_ERROR.getMessage());
        }
    }
}
