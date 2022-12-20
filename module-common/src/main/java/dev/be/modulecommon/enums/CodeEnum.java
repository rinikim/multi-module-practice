package dev.be.modulecommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * return code, return message
 */
@Getter
@AllArgsConstructor
public enum CodeEnum {
    SUCCESS("0000", "SUCCESS"),
    UNKNOWN_ERROR("9999", "UNKNOWN_ERROR");

    private String code;
    private String message;
}
