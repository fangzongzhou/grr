package com.fzz.util;

/**
 * Created by tuyoo on 2017/3/17.
 */
public class PathUtil {

    public String getProjectPath() {

        return Class.class.getResource("/").getPath();
    }
}
