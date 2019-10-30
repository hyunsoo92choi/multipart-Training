package com.hschoi.multipart.common.code;

import com.hschoi.multipart.common.code.mapper.EnumType;

/**
 * <pre>
 * com.hschoi.multipart.common.code_ResponseCodeType.java
 * 
 * </pre>
 * @date : Oct 30, 2019
 * @author : hschoi
 */
public enum ResponseCodeType implements EnumType {
	OK("S_001","정상처리되었습니다.", 200)
  , INVALID_FILE("E_001","처리 가능한 csv파일이 아닙니다.", 404)
  , FAIL_FILE_READ("E_002","파일 읽기에 실패하였습니다.", 404)
  , FAIL_FILE_PARSE("E_003","파일 파싱에 실패하였습니다.", 404)
  , INVALID_DEVICETYPE("E_003","올바른 단말기타입이 아닙니다.", 404)
	;
	
	private String message;
	private final int status;
	
	ResponseCodeType(String code, String message, int status) {
		this.message = message;
		this.status = status;
	}
	
	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return name();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	public int getStatus() {
		return status;
	}

}
