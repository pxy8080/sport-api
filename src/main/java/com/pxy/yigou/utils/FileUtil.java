package com.pxy.yigou.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUtil {
    /**
     * @param targetPath 文件上传的目标路径
     * @param file       上传的文件，类型为 MultipartFile
     * @return filePathAndName   上传文件的路径名/文件名
     */
    public static String uploadFileUtil(String targetPath, String name, MultipartFile file) {
        String filePathAndName = "";
        //截取文件后缀
        String originalFilename = file.getOriginalFilename();
        String subName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //获取文件新名字
        String newName = name + subName;
        System.out.println("subName:" + subName);
        try {
            File newFilePath = new File(targetPath);//获取路径的File对象
            if (!newFilePath.exists()) {
                newFilePath.mkdirs();
            }
            //拼接文件的: 绝对路径名 + "\" + 文件原始名
            filePathAndName = targetPath + File.separator + newName;
            File file1 = new File(filePathAndName);//创建File对象
            file.transferTo(file1);//用新创建的对象调用传输方法，就完成了上传功能
            System.out.println(filePathAndName + " 上传成功");
        } catch (Exception e) {
            System.out.println(filePathAndName + " 上传失败");
        }
        return filePathAndName;
    }
}
