package com.test.controller;


import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Iterator;

@Controller
public class IndexController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index() {
        return "index page";
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(MultipartHttpServletRequest request) {
        try {
            Iterator<String> itr = request.getFileNames();
            MultipartFile multipartFile;
            File convFile;
            while (itr.hasNext()) {
                multipartFile = request.getFile(itr.next());
                CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
                DiskFileItem fi = (DiskFileItem) cf.getFileItem();
                convFile = fi.getStoreLocation();
                FileUtils.copyFile(convFile, new File("c:\\", cf.getOriginalFilename()));
            }
            return "{\"success\":true, \"message\":\"上传成功\"}";
        } catch (Exception e) {
            return "{\"success\":false, \"message\":\"上传失败\"}";
        }
    }
}
