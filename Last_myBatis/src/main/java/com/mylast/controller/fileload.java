package com.mylast.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/user")
public class fileload {
    @RequestMapping("/file")
    public String file(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        String path = request.getSession().getServletContext().getRealPath("upload/mypropertise/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        fileUpload.parseRequest(request);
        List<FileItem> items = fileUpload.parseRequest(request);
        for (FileItem item : items) {
            //判断当前item是否为上传文件
            if (item.isFormField()) {
                //普通表单项
            } else {
                //上传文件项
                String name = item.getName();
                item.write(new File(path, name));
                //删除临时文件
                item.delete();
            }
        }
        return "fileupload";
    }

    @RequestMapping("/file1")
    public String file1(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传");
        String path = request.getSession().getServletContext().getRealPath("upload/mypropertise/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //上传文件项
        String name = upload.getOriginalFilename();
        upload.transferTo(new File(path, name));

        return "fileupload";
    }
}
