package com.hschoi.multipart.app.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * com.hschoi.multipart.app.service_FileService.java
 * 
 * </pre>
 * @date : Oct 30, 2019
 * @version : 
 * @author : hschoi
 */
public interface FileService {
	public Integer registerData(MultipartFile file);
}
