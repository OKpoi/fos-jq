package com.fos.util;

import com.fos.entity.user.TbUser;
import com.fos.enums.user.UserEnums;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Slf4j
public class PathGenHelper {

    public static Map<String, String> pathMap;
    private static String WINDOWS = "win";
    private static String LININX = "linux";
    private static String USERDIR = "/upload/item/user/";


    @Value("${Env.fileUpLoadPath}")
    public void setPathList(Map<String, String> data) {
        pathMap = data;
    }

    public static String generalImageAndImaePath(String fileOriginalFilename, InputStream fileInputStream, TbUser tbUser) {

        log.info("==================begin to insert img=====================");
        //1.获取创建基本资源路径
        String basePath = getDirBasePath();

        //2.创建图片所在路径
        String userImgPath = getUserImgPath(basePath, tbUser);

        //3.压缩图片并生成全路径
        String targetImg = generateTargetImg(fileOriginalFilename, userImgPath, fileOriginalFilename, fileInputStream);

        return targetImg;
    }


    private static String getDirBasePath() {
        String basePath = null;
        String os = System.getProperty("os.name");
        //2.windows
        if (os.toLowerCase().startsWith(WINDOWS)) {
            basePath = pathMap.get(WINDOWS);
        } else {
            basePath = pathMap.get(LININX);
        }
        basePath = basePath.replace(System.getProperty("file.separator"), "/");
        return basePath;
    }


    private static String getUserImgPath(String basePath, TbUser tbUser) {
        String imgPath = USERDIR + tbUser.getUserId() + "/";
        return imgPath.replace(System.getProperty("file.separator"), "/");
    }

    private static String generateTargetImg(String basePath, String imgPath, String fileOriginalFilename, InputStream fileInputStream) {
        String resourcePath = basePath + imgPath;
        File file = new File(resourcePath);
        if (file.isDirectory() && !file.exists()) {
            file.mkdirs();
            String fileName = getRandomFileName();
            String exetension = gerFileExtension(fileOriginalFilename);
            String targetImg = resourcePath + fileName + exetension;
            File desnationFile = new File(targetImg);
            try {
                Thumbnails.of(fileInputStream).size(400, 400).outputQuality(1.0f).toFile(desnationFile);
                return fileName + exetension;
            } catch (IOException e) {
                LoggerHelper.createCustomeExcpetionLog(PathGenHelper.class.getSimpleName(), "getUserImgPath", e.getMessage());
                return null;
            }

        } else {
            LoggerHelper.createCustomeExcpetionLog(PathGenHelper.class.getSimpleName(), "getUserImgPath", UserEnums.INSERT_IMG_ERROR.getMsg());
            return null;
        }
    }

    public static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        int randomnum = ((Random) random).nextInt(9999) + 1000;
        String currenTime = simpleDateFormat.format(new Date());
        return currenTime + randomnum;

    }

    private static String gerFileExtension(String fileOriginalFilename) {
        return fileOriginalFilename.substring(fileOriginalFilename.lastIndexOf("."));
    }

}
