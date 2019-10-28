package com.woniu.movie.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传图片到腾讯对象存储
 */
public class TencentUploadUtil {
    //存储客户端
    private static COSClient cosClient;
    // 指定要上传到的存储桶
    private static final String BUCKET_NAME = "fanchw-1259090380";
    //存储后图片网址
    private static final String IMG_URl = "https://fanchw-1259090380.cos.ap-shanghai.myqcloud.com/";

    /*初始化存储对象各项参数*/
    static {
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDGLG4iFv4LUTIyUHByd9VgjcP0BDARZYQ";
        String secretKey = "LU8cx88zhHiuzvhJn98wUt9FE4lFalmf";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-shanghai");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);
    }

    /**
     * 将图片对象存入腾讯对象存储服务器
     *
     * @param multipartFile 前端传来的图片文件
     * @return 返回图片在腾讯云的访问路径
     */
    public static String uploadImgToTencentCloud(MultipartFile multipartFile) throws IOException {
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        // 设置输入流长度
        objectMetadata.setContentLength(multipartFile.getSize());
        UUID uuid = UUID.randomUUID();
        //获取图片名称
        String fileName = multipartFile.getOriginalFilename();
        if (multipartFile.getSize() == 0 || fileName == null || "".equals(fileName)) {
            return null;
        }
        //获取文件后缀即文件类型
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        // 设置 Content type, 默认是 application/octet-stream
        objectMetadata.setContentType("image/" + suffix.substring(1));
        String newFileName = uuid.toString() + suffix;
        PutObjectResult putObjectResult = cosClient.putObject(BUCKET_NAME, newFileName, fileInputStream, objectMetadata);
        String etag = putObjectResult.getETag();
        //关闭输入流
        fileInputStream.close();
        return IMG_URl + newFileName;
    }
}
