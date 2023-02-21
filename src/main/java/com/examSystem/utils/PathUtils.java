package com.examSystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PathUtils {
    public static final String CAPTCHA = "NING4454";

    public static String generateFilePath(String originalPath) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String format = sdf.format(new Date());

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        int index = originalPath.lastIndexOf(".");

        String fileType = originalPath.substring(index);
        return new StringBuilder().append(format).append("/").append(uuid).append(fileType).toString();

    }
}
