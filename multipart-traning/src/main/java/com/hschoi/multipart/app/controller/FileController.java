package com.hschoi.multipart.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * com.hschoi.multipart.app.controller_FileController.java
 * 
 * </pre>
 * @date : Oct 30, 2019
 * @version : 
 * @author : hschoi
 */
@RestController
@RequestMapping(value = "api/{version}/files")
public class FileController {
	
	private final Logger log = LoggerFactory.getLogger(FileController.class);
	
}
