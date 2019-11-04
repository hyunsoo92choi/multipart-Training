package com.hschoi.multipart.app.controller;

import java.io.IOException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	
	/**
	 * <pre>
	 * 1. 개요 : @RequestPart 를 사용하여 업로드 하는 방식.
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : requestPartUpload
	 * @date : Nov 4, 2019
	 * @author : hschoi
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Nov 4, 2019		hschoi				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param file
	 * @return
	 */ 	
	@PostMapping(value = "/upload", consumes = { "multipart/form-data" })
    public ResponseEntity<Void> requestPartUpload(
            @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
    	log.info("File uploading start");
    	return null;
    }
	
	/**
	 * <pre>
	 * 1. 개요 : MultipartServletRequest 를 사용하여 업로드 하는 방식.
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : multipartHttpServletRequestUpload
	 * @date : Nov 4, 2019
	 * @author : hschoi
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Nov 4, 2019		hschoi				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */ 	
	@PostMapping(value = {"/upload2"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> multipartHttpServletRequestUpload(MultipartHttpServletRequest request) throws IOException {
		MultipartFile file = request.getFile("file");
		
		System.out.println(file.getName()); // 파일의 파라미터 이름
		System.out.println(file.getSize()); // 파일의 사이즈
		System.out.println(file.getOriginalFilename()); // 파일의 실제 이름
		byte[] data = file.getBytes(); // 파일실제  내용
		
		return null;
	}
	
}
