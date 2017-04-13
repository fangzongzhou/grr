package com.fzz.util;

/**
 * Created by tuyoo on 2017/3/17.
 */
public class PathUtil {

    public static String getProjectPath() {

        return Class.class.getResource("/").getPath();
    }
}
