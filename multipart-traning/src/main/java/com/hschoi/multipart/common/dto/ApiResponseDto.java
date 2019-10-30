package com.hschoi.multipart.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <pre>
 * com.hschoi.multipart.common.dto_ApiResponseDto.java
 * 
 * </pre>
 * @date : Oct 30, 2019
 * @author : hschoi
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiResponseDto <T> {
	private int code;
    private String message;
    private T data;
}
