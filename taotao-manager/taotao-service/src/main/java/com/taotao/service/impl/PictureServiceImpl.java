package com.taotao.service.impl;

import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import util.UploadUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {

    @Value("${fast_address}")
    private String FAST_ADDRESS;

    @Override
    public Map uploadPicture(MultipartFile file) {
        Map map = new HashMap<>();
        try {
            map = UploadUtils.fileUpload(file);
            String url = map.get("fileUrl").toString();
            if(map != null){
                map.put("error",0);
                map.put("url",FAST_ADDRESS+"/"+url);
            }else{
            map.put("error",1);
            map.put("message","文件上传失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
