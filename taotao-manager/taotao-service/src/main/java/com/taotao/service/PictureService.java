package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PictureService {

    /**
     * 文件上传
     * @param file
     * @return
     */
    Map uploadPicture(MultipartFile file);
}
