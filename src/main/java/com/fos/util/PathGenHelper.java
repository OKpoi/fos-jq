package com.fos.util;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;

public class PathGenHelper {


    public static List<String> PathList;

    @Value("${Env.fileUpLoadPath}")
    public void setPathList(List<String> data) {
        PathList = data;
    }

    public static String generalPath(String fileOriginalFilename) {

        String basePath = "";
        //1.获取操作系统
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            basePath = "";
        }
        return null;
    }


}
