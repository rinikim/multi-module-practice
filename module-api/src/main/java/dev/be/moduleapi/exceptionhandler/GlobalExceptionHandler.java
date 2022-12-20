package dev.be.moduleapi.exceptionhandler;

import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.response.CommonResponse;
import dev.be.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public CommonResponse handlerCustomException(CustomException e) {
        return CommonResponse.builder()
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }

    /**
     * 아무리 꼼꼼하게 코딩했더라도 잡지못하는 exception 이 있을 수 있다.
     * 그것을 대비하기 위한 코드
     */
    @ExceptionHandler(Exception.class)
    public CommonResponse handlerException(Exception e) {
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

}
