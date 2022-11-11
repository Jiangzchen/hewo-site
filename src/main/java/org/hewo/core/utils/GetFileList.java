package org.hewo.core.utils;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @Author: 李涵祥
 * @Date: 2022/7/27
 */
public class GetFileList {

    /**
     * 通过文件夹路径收集指定类型文件
     *
     * @param strPath  文件路径
     * @param fileType 文件类型
     * @return
     */
    public static List<File> getFileList(String strPath, String fileType) {
        List<File> filelist = new ArrayList<>();
        File dir = new File(strPath);
        // 该文件目录下文件全部放入数组
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                // 判断是文件还是文件夹
                if (files[i].isDirectory()) {
                    // 获取文件绝对路径
                    getFileList(files[i].getAbsolutePath(), fileType);
                    // 判断文件名是否以.XXX结尾
                } else if (fileName.endsWith(fileType)) {
                    String strFileName = files[i].getAbsolutePath();
                    filelist.add(files[i]);
                } else {
                    continue;
                }
            }

        }
        return filelist;
    }

}
