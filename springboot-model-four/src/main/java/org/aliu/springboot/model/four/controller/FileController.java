package org.aliu.springboot.model.four.controller;

import lombok.extern.slf4j.Slf4j;
import org.aliu.springboot.model.four.domain.common.ResponseResult;
import org.aliu.springboot.model.four.exception.ErrorCodeEnum;
import org.aliu.springboot.model.four.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * 文件上传下载
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Slf4j
@RestController
@RequestMapping("/api/files")
public class FileController {

    @Resource(name = "localFileServiceImpl")
    private FileService fileService;

    /**
     * 文件上传功能
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResponseResult<String> upload(@NotNull MultipartFile file) {
        //文件上传...
        try {
            fileService.upload(file.getInputStream(), file.getOriginalFilename());
        } catch (Exception e) {
            log.error("文件上传失败", e);
            throw new RuntimeException(ErrorCodeEnum.FILE_UPLOAD_ERROR.getMessage());
        }
        return ResponseResult.success(file.getOriginalFilename());
    }
}
