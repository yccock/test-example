package com.test.controller;


import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;

@Controller
public class IndexController {

    @RequestMapping(value = "login")
    public String login(HttpServletRequest request) {
        request.getSession().getAttribute("wdx");
        return "login";
    }

    @RequestMapping(value = "")
    public String index(HttpServletRequest request) {
        request.getSession().getAttribute("wdx");
        return "index";
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

    @ResponseBody
    @RequestMapping(value = "json")
    public String json() {
        String res = "{\"success\":\"true\",\"data\":{\"user\":{\"userId\":123,\"userName\":\"test\"},\"order\":[{\"id\":1,\"name\":\"京东\"},{\"id\":2,\"name\":\"天猫\"},{\"id\":3,\"name\":\"苏宁\"}],\"trades\":[{\"id\":546,\"tradeName\":\"语文\"},{\"id\":547,\"tradeName\":\"数学\"}]}}";
        return res;
    }
}
