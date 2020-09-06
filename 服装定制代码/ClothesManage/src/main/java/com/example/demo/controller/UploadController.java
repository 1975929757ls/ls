package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Picture;
import com.example.demo.repository.PictureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author luoliang
 * @date 2018/2/12
 **/
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private PictureRepository pictureRepository;
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/singlefile/{info}")
    public Object singleFileUpload( MultipartFile file,@PathVariable("info") String info) {
//        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        System.out.println(info);
        if (Objects.isNull(file) || file.isEmpty()) {
            System.out.println("文件为空");
            logger.error("文件为空");
            return "文件为空，请重新上传";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            System.out.println(path);
            String s= String.valueOf(path);
            System.out.println(s);
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            Picture picture=new Picture();
            picture.setSrc(s);
            picture.setInfo(info);
            pictureRepository.save(picture);
            System.out.println("文件写入成功...");
            logger.debug("文件写入成功...");
            return s;
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }
}
