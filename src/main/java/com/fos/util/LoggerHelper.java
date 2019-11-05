package com.fos.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerHelper {

    public static void createCustomeExcpetionLog(
            String className, String methodName, String exceptionMsg) {
        log.error("==================Exception====================");
        log.error(className + "-> " + methodName + " -> " + exceptionMsg);
        log.error("===============================================");
    }

    public static void createServerExcpetionLog(String exceptionMsg, String requestURL) {
        log.error("==================Exception====================");
        log.error(exceptionMsg + " @ " + requestURL);
        log.error("===============================================");
    }
}
