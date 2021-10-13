package org.aliu.springboot.model.four.service;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.InputStream;

/**
 * 文件上传服务接口
 *
 * @author liusheng
 * @date 2021/9/27
 */
public interface FileService {

    /**
     * 文件流上传
     * @param inputStream
     * @param fileName
     */
    void upload(InputStream inputStream, String fileName);

    /**
     * 文件上传
     * @param file
     */
    void upload(File file);
}
