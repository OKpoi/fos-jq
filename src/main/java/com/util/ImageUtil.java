package com.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    public static String generateThumbnail(InputStream thumbnail, String fileName, String targetAddr) {
        //获得随机文件名
        String reailName = getRandomFileName();
        //获取文件扩展名
        String extension = gerFileExtension(fileName);
        //创建文件路径
        makeDirPath(targetAddr);
        //路径加文件名称
        String relativeAddr = targetAddr + reailName + extension;
        //文件地址
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        //进行图片压缩
        try {
            Thumbnails.of(thumbnail).size(400, 400).outputQuality(1.0f).toFile(dest);
        } catch (IOException io) {
            io.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及的目录
     *
     * @param targetAddr
     */

    private static void makeDirPath(String targetAddr) {
        //图片的所在地址
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 生成随机文件名 随机数+日期
     */
    public static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        int randomnum = ((Random) random).nextInt(9999) + 1000;
        String currenTime = simpleDateFormat.format(new Date());
        return currenTime + randomnum;

    }

    /**
     * 获取输入文件流的扩展名
     */
    private static String gerFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }


}
