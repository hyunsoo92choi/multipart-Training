package com.hschoi.multipart.common.code;

import java.util.Arrays;
import java.util.List;

import com.hschoi.multipart.common.code.mapper.EnumType;
import com.hschoi.multipart.common.exception.CustomException;
import static com.hschoi.multipart.common.code.ResponseCodeType.INVALID_DEVICETYPE;

/**
 * <pre>
 * com.hschoi.multipart.common.code_DeviceType.java
 * 
 * </pre>
 * @date : Oct 30, 2019
 * @version : 
 * @author : hschoi
 */
public enum DeviceType implements EnumType {
	PHONE("DIS201901","스마트폰")
  , DESKTOP("DIS201902","데스크탑 컴퓨터")
  , LAPTOP("DIS201903","노트북 컴퓨터")
  , PAD("DIS201905","스마트패드")
  , ETC("DIS201904","기타")
	  ;

	private String deviceName;

	DeviceType(String code, String deviceName) {
		this.deviceName = deviceName;
	}

	@Override
	public String getCode() {
		return name();
	}

	@Override
	public String getMessage() {
		return deviceName;
	}

	public static DeviceType of(String str) {
		return Arrays.stream(DeviceType.values())
					 .filter(e -> e.name().equals(str.toUpperCase())).findFirst()
					 .orElseThrow( () -> new CustomException(INVALID_DEVICETYPE) );
	}

	public static DeviceType is(String deviceName) {
		for (DeviceType value : values()) {
			if (deviceName.startsWith(value.deviceName)) {
				return value;
			}
		}
		return DeviceType.ETC;
	}
}
