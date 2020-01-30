package com.xd.sell.Exception;

import com.xd.sell.enums.ResultEnum;

/**
 * @Auther: k
 * @Date: 2020/1/29 10:43
 * @Description:
 */
public class SellException extends RuntimeException {
    private Integer code;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public SellException(ResultEnum resultEnum) {
        // 把message的内容传到父类的构造方法
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
