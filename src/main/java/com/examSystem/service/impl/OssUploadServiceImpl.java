package com.examSystem.service.impl;

import com.examSystem.domain.ResponseResult;
import com.examSystem.service.UploadService;
import com.examSystem.utils.PathUtils;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
@ConfigurationProperties(prefix = "oss")
@Data
public class OssUploadServiceImpl implements UploadService {

    private String accessKey;
    private String secretKey;
    private String bucket;
    private String outChain;

    @Override
    public ResponseResult uploadImg(MultipartFile img) {
        String filename = img.getOriginalFilename();
        String fileName = PathUtils.generateFilePath(filename);
        String result = ossUpload(img, fileName);
        return ResponseResult.okResult(result);
    }

    private String ossUpload(MultipartFile img, String fileName) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        try {
            InputStream is = img.getInputStream();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(is, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return outChain + "/" + fileName;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    ex2.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "error";
    }
}
