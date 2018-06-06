package com.paul.logisticsmanagementsystem.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/19/2018
 * Time: 9:37 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class FileManager {

    public  static String  uploadFile(HttpServletRequest request, MultipartFile file) throws Exception{
        //上传目录地址
        String uploadDir = request.getSession().getServletContext().getRealPath("/WEB-INF/static/img/") + "upload/";
       // String uploadDir=request.getContextPath()+"/upload/";
        //如果目录不存在，自动创建文件夹
        File dir = new File(uploadDir);
        if (!dir.exists()){
            dir.mkdir();
        }
        //上传文件名
        String filename = file.getOriginalFilename();
        System.out.println("文件名："+filename);
        String allfilename=uploadDir + filename;
        //服务器端保存的文件对象
        File serverFile = new File(allfilename);
        //将上传的文件写入到服务器端文件里
        file.transferTo(serverFile);
        return "upload/"+filename;
    }



}
