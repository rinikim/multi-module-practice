package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String returnCode;
    private String returnMessage;
    private T info;

    public CommonResponse(CodeEnum codeEnum) {
        this.returnCode = codeEnum.getCode();
        this.returnMessage = codeEnum.getMessage();
    }

    /**
     * 성공으로 간주
     * @param info
     */
    public CommonResponse(T info) {
        this.returnCode = CodeEnum.SUCCESS.getCode();
        this.returnMessage = CodeEnum.SUCCESS.getMessage();
        this.info = info;
    }

    public CommonResponse(CodeEnum codeEnum, T info) {
        this.returnCode = codeEnum.getCode();
        this.returnMessage = codeEnum.getMessage();
        this.info = info;
    }
}
