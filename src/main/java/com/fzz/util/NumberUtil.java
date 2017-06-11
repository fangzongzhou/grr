package com.fzz.util;

import java.util.Random;

/**
 * Created by huayu on 2017/6/11.
 */
public class NumberUtil {
    public static int getRandomInt() {
        int min=10;
        int max=300;
        Random random = new Random();

        return random.nextInt(max)%(max-min+1)+min;
    }
}
