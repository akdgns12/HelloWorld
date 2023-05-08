package com.project.helloworld.util;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class S3Uploader {
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    /**
     * 파일을 입력받고 확장자에 맞게 S3에 저장합니다.
     * @param multipartFile: 저장될 이미지 파일
     * @param dirName: 저장될 경로 // 지금은 avatar, article이 있고 나중에 필요한 경로가 다 정해지면 다른 경로는 안받도록 할게요
     * @return 저장된 이미지 경로를 return 합니다.
     * @throws IOException
     */
    public String uploadFiles(MultipartFile multipartFile, String dirName) throws IOException {
        File uploadFile = convert(multipartFile).orElseThrow(()-> new IllegalArgumentException("MultipartFile -> File convert fail"));
        return upload(uploadFile,dirName);
    }

    public String upload(File uploadFile, String filePath){
        String fileName = new StringBuffer().append(filePath)
                .append("/")
                .append(UUID.randomUUID())
                .append(".")
                .append(StringUtils.getFilenameExtension(uploadFile.getName()))
                .toString();

        String uploadImageUrl = putS3(uploadFile,fileName);
        removeNewFile(uploadFile);
        return uploadImageUrl;
    }

    private String putS3(File uploadFile, String fileName){
        amazonS3Client.putObject(new PutObjectRequest(bucket,fileName,uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3Client.getUrl(bucket,fileName).toString();
    }

    private boolean removeNewFile(File targetFile){
        if(targetFile.delete()){
            return true;
        }
        return false;
    }

    private Optional<File> convert(MultipartFile file) throws IOException{
        File convertFile = new File(System.getProperty("user.dir") + "/" + file.getOriginalFilename());
        if(convertFile.exists()  || convertFile.createNewFile()){
            try(FileOutputStream fos = new FileOutputStream(convertFile)){
                fos.write(file.getBytes());
            }
            return Optional.of(convertFile);
        }
        return Optional.empty();
    }
}
