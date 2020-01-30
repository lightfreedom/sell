package com.xd.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

    NEW(0,"未支付"),
    FINISHED(1,"支付完成")
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
