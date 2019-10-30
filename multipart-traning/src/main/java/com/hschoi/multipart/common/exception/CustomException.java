package com.hschoi.multipart.common.exception;

import com.hschoi.multipart.common.code.ResponseCodeType;

import lombok.Getter;

/**
 * <pre>
 * com.hschoi.multipart.common.exception_CustomException.java
 * 
 * </pre>
 * @date : Oct 30, 2019
 * @author : hschoi
 */
@Getter
public class CustomException extends RuntimeException {

	private ResponseCodeType resultCode;

    public CustomException(ResponseCodeType resultCode) {
        super(resultCode.getMessage());        
        this.resultCode = resultCode;
    }

    public CustomException(ResponseCodeType resultCode, String additionalString) {
        super(resultCode.getMessage() + additionalString);
        this.resultCode = resultCode;
    }
}
