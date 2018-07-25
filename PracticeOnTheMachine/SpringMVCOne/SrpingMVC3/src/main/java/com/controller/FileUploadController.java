package com.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件上传
 */
@Controller
@RequestMapping("/File")
public class FileUploadController {
    //定义图片存储位置(到D盘File文件夹下)
    private final String UPLOAD_ROOT_PATH = "D:" + File.separator + "File";

    /**
     * 使用Apache方式上传
     * 上传单个文件
     *
     * @param username
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/single1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String m1(@RequestParam("username") String username,
                     @RequestParam("file") MultipartFile multipartFile) {
        System.out.println("普通的表单域：" + username);

        //1  处理文件上传
        if (!multipartFile.isEmpty()) {
            //2  如果不为空，再上传
            BufferedOutputStream out = null;
            try {
                // 3 得到字节数据，最终要写出去
                byte[] bytes = multipartFile.getBytes();
                // 4 先看我们目录是否存在，如果不存在创建
                File parent = new File(UPLOAD_ROOT_PATH);
                if (!parent.exists())
                    parent.mkdirs();

                // 5 获取原始文件名
                String originalFilename = multipartFile.getOriginalFilename();

                // 6 我们解析出文件的前缀 aa.txt -->  aa
                String prefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));

                // 7 解析后缀 aa.doc --> .doc
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

                // 8 拼接新的文件名
                String newFileName = prefix + System.currentTimeMillis() + suffix;
                System.out.println("存入数据库时的文件名是:" + newFileName);

                // 9 构建输出文件目的地
                File upFile = new File(UPLOAD_ROOT_PATH + File.separator + newFileName);
                System.out.println("输出(到D盘File文件夹下)文件目的地是:" + upFile);

                // 10 构建输出对象
                out = new BufferedOutputStream(new FileOutputStream(upFile));

                out.write(bytes);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "单个文件上传成功啦！";
    }


    /**
     * 使用servlet3.0解析器
     * 上传单个文件
     *
     * @param username
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/single2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String m2(@RequestParam("username") String username,
                     @RequestParam("file") MultipartFile multipartFile) {
        System.out.println("普通的表单域：" + username);

        //1  处理文件上传
        if (!multipartFile.isEmpty()) {
            //2  如果不为空，再上传
            try {
                // 3 得到字节数据，最终要写出去
                byte[] bytes = multipartFile.getBytes();
                // 4 先看我们目录是否存在，如果不存在创建
                File parent = new File(UPLOAD_ROOT_PATH);
                if (!parent.exists())
                    parent.mkdirs();

                // 5 获取原始文件名
                String originalFilename = multipartFile.getOriginalFilename();

                // 6 我们解析出文件的前缀 aa.txt -->  aa
                String prefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));

                // 7 解析后缀 aa.doc --> .doc
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

                // 8 拼接新的文件名
                String newFileName = prefix + System.currentTimeMillis() + suffix;
                System.out.println("存入数据库时的文件名是:" + newFileName);

                // 9 构建输出文件目的地
                File upFile = new File(UPLOAD_ROOT_PATH + File.separator + newFileName);
                System.out.println("输出(到D盘File文件夹下)文件目的地是:" + upFile);

                // 10 直接通过multipartFile转换出去就行了
                multipartFile.transferTo(upFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "单个文件上传成功啦！";
    }

    /**
     * 使用servlet3.0解析器
     * 上传多个文件
     *
     * @param username
     * @param multipartFiles
     * @return
     */
    @RequestMapping(value = "/Multiple3", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String m3(@RequestParam("username") String username,
                     @RequestParam("file") MultipartFile[] multipartFiles) {
        System.out.println("普通的表单域：" + username);

        //1  处理文件上传
        for (int i = 0; i < multipartFiles.length; i++) {
            MultipartFile multipartFile = multipartFiles[i];
            if (!multipartFile.isEmpty()) {
                //2  如果不为空，再上传
                try {
                    // 3 得到字节数据，最终要写出去
                    byte[] bytes = multipartFile.getBytes();
                    // 4 先看我们目录是否存在，如果不存在创建
                    File parent = new File(UPLOAD_ROOT_PATH);
                    if (!parent.exists())
                        parent.mkdirs();

                    // 5 获取原始文件名
                    String originalFilename = multipartFile.getOriginalFilename();

                    // 6 我们解析出文件的前缀 aa.txt -->  aa
                    String prefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));

                    // 7 解析后缀 aa.doc --> .doc
                    String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

                    // 8 拼接新的文件名
                    String newFileName = prefix + System.currentTimeMillis() + suffix;
                    System.out.println("存入数据库时文件名是:" + newFileName);

                    // 9 构建输出文件目的地
                    File upFile = new File(UPLOAD_ROOT_PATH + File.separator + newFileName);
                    System.out.println("输出(到D盘File文件夹下)文件目的地是:" + upFile);

                    // 10 直接通过multipartFile转换出去就行了
                    multipartFile.transferTo(upFile);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "多个文件上传成功啦！";
    }

}
