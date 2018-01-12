package util;

import fastDFS.FastDFSClient;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

public class UploadUtils {

    /**
     * 文件上传
     * @param file 要上传的文件
     * @return
     * @throws Exception
     */
    public static Map fileUpload(MultipartFile file) throws Exception{
        // 文件上传成功后返回文件在文件服务器中存储的路径fileUrl
        String fileUrl = FastDFSClient.uploadFile(file.getInputStream(), file.getOriginalFilename());
        System.out.println(" 上传文件 " + file.getOriginalFilename() + " 成功, 文件Url=" + fileUrl);
        Map fileMap=new HashMap();
        fileMap.put("fileUrl",fileUrl);
        fileMap.put("fileName",file.getOriginalFilename());
        return fileMap;
    }
}
