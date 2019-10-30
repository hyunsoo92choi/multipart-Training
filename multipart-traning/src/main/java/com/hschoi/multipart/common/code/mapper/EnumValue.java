package com.hschoi.multipart.common.code.mapper; 
/**
 * <pre>
 * com.hschoi.multipart.common.code.mapper_EnumValue.java
 * 
 * </pre>
 * @date : Oct 30, 2019 
 * @author : hschoi
 */
public class EnumValue {
	private String code;
	private String message;

	public EnumValue(EnumType enumMapperType) {
		code = enumMapperType.getCode();
		message = enumMapperType.getMessage();
	}
}
