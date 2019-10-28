package com.woniu.movie.util;

import com.github.pagehelper.PageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 功能描述:<br>
 * 〈文件上传工具〉
 *
 * @author Administrator
 * @create 2019/10/18
 * @since 1.0.0
 */
public class FileUploadUtil {
    //文件上传
    public static String upload(MultipartFile uploadImg, HttpServletRequest request) throws IOException {
        //获取存放图片的位置
        String path = request.getServletContext().getRealPath("/img/show_site");
        String newpath=request.getContextPath();
        System.out.println(path+"=====");
        System.out.println(newpath+"-------------");
        File f = new File(path);
        if (!f.exists()){
            f.mkdir();
        }
        //获取图片名称
        String fileName = uploadImg.getOriginalFilename();
        System.out.println("图片名称:"+fileName);
        UUID uuid = UUID.randomUUID();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("suffix:"+suffix);
        String newFileName = uuid.toString()+suffix;
        System.out.println("newFileName:"+newFileName);
        //创建图片对象
        File file = new File(f,newFileName);
        System.out.println("file:"+file);
        //上传
        uploadImg.transferTo(file);
        return  newFileName;
    }
}
