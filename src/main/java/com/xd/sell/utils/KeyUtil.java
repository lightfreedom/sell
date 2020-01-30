package com.xd.sell.utils;

import java.util.Random;

/**
 * @Auther: k
 * @Date: 2020/1/29 11:09
 * @Description:生成主键
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        // 生成六位随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}
