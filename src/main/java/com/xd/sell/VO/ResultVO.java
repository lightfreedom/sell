package com.xd.sell.VO;

import lombok.Data;

/**
 * @Auther: k
 * @Date: 2020/1/27 21:24
 * @Description:http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {
    // 错误码 code 0 成功
    private Integer code;

    // 提示信息
    private String msg;

    // 具体内容
    private T data;

}
