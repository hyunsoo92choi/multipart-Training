package com.hschoi.multipart.common.file;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hschoi.multipart.common.code.DeviceType;

import lombok.Getter;

/**
 * <pre>
 * com.hschoi.multipart.common.file_FileHandler.java
 * 
 * </pre>
 * @date : Oct 30, 2019
 * @version : 
 * @author : hschoi
 */
@Getter
public class FileHandler {
	
	private final static Logger log = LoggerFactory.getLogger(FileHandler.class);
	
	private List<DeviceType> deviceTypeName;
	private List<String> body;
	
	// Contructor
	public FileHandler(List<DeviceType> deviceTypeName, List<String> rows) {
        this.deviceTypeName = deviceTypeName; 
        this.body = rows;
    }
	
	
	
	
}
