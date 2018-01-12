package com.taotao.controller;

import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import util.JsonUtils;

import java.util.Map;

/**
 * 上传图片处理
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile){
        Map resultMap = pictureService.uploadPicture(uploadFile);
        String json = JsonUtils.objectToJson(resultMap);
        return json;
    }
}

