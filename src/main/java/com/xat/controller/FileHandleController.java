package com.xat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 淡漠
 */
@Slf4j
@RestController
public class FileHandleController {
    // 模板文件存储目录
    private static final String FILE_DIRECTORY = "/root/account/template/";
    private static final String FINAL_FILE_DIRECTORY = "/root/account/result/";



    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file) {
        try {
            // 指定上传文件保存的路径
            String uploadPath = "/root/account/input/";
            // 获取上传文件的原始文件名
            String fileName = file.getOriginalFilename();
            log.info("文件名为：{}",fileName);
            // 构造保存文件的完整路径
            String filePath = uploadPath + fileName;
            // 保存文件到指定路径
            file.transferTo(new File(filePath));
            log.info("文件上传成功");
            return ResponseEntity.ok("上传成功啦，小马真棒，么么哒！");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件上传失败，异常信息：{}",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败");
        }
    }


    @GetMapping("/downloadTemplate/{fileName}")
    public ResponseEntity<Resource> downloadTemplateFile(@PathVariable String fileName) {
        try {
            Path filePath = Paths.get(FILE_DIRECTORY).resolve(fileName);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        try {
            Path filePath = Paths.get(FINAL_FILE_DIRECTORY).resolve(fileName);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}


