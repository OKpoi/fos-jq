package com.util;

/**
 * 此类是路径工具类
 */

public class PathUtil {

    /**
     * 此方法获得web应用中图片的存储路径
     *
     * @return
     */
    public static String getImgBasePath() {
        //获得操作系统
        String os = System.getProperty("os.name");

        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            //此处路径在项目上线后会做相对应的修改
            basePath = "D:/fos-resources/img";
        } else {
            //部署再云服务器上
            basePath = "/home/fos-resources/img";
        }
        basePath = basePath.replace(System.getProperty("file.separator"),"/" );
        return basePath;
    }


    /**
     * 获得上传的用户头像的路径
     */
    public static String getUserImgPath(Integer userId) {
        String imgPath = "/upload/item/user/" + userId + "/";
        return imgPath.replace(System.getProperty("file.separator"),"/");

    }
}
