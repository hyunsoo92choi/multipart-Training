package com.hschoi.multipart.app.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping(value = "/upload", consumes = { "multipart/form-data" })
    public ResponseEntity<Void> upload(
            @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
    	
    	return null;
    }
	
}
