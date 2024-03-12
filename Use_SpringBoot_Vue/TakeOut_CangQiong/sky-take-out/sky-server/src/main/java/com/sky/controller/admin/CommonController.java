package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import com.sky.utils.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController("adminCommonController")
@RequestMapping("/admin/common")
@Api(tags = "通用的相关接口")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
        log.info("菜品图片文件上传");

        try {
            // 文件原始名
            String originalFilename = file.getOriginalFilename();
            // 截取后缀
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 创建新的名字
            String objectname = UUID.randomUUID().toString() + extension;
            // 文件上传
            String filepath = aliOssUtil.upload(file.getBytes(), objectname);
            return Result.success(filepath);
        } catch (Exception e) {
            log.info("文件上传失败：{}", e.getMessage());
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);
    }

}
