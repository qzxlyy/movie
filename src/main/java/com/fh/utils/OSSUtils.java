package com.fh.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.File;
import java.util.UUID;

public class OSSUtils {
    public static String uploadFile(File file){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpointName = "oss-cn-qingdao.aliyuncs.com";
        String endpoint ="http://"+endpointName;
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        /*String accessKeyId = "LTAI4G99RRxHWeAwBKpcPjFg";
        String accessKeySecret = "Yw2sZ6ZdmmVfSeW2Pe9ODlAReXxUU8";
        String bucketName="changwenjun";*/
        String accessKeyId = "LTAI4GCz7KkETjR7BiBBL9R1";
        String accessKeySecret = "faIH18hlAOukovtispEiM1Byw3jERa";
        String bucketName="qzximgs";
        String name = file.getName();
        int i = name.lastIndexOf(".");
        String substring = name.substring(i);
        UUID uuid = UUID.randomUUID();
         String newFile =  uuid+substring;

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,file.getName(),file);

// 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
// ObjectMetadata metadata = new ObjectMetadata();
// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
// metadata.setObjectAcl(CannedAccessControlList.Private);
// putObjectRequest.setMetadata(metadata);

// 上传文件。
        PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
// 关闭OSSClient。
        ossClient.shutdown();
        return "http://"+bucketName+"."+endpointName+"/"+file.getName();
    }
}
