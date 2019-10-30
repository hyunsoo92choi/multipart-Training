package com.hschoi.multipart.common.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.hschoi.multipart.common.code.DeviceType;
import com.hschoi.multipart.common.exception.CustomException;

import static com.hschoi.multipart.common.code.ResponseCodeType.FAIL_FILE_READ;

/**
 * <pre>
 * com.hschoi.multipart.common.file_FileReader.java
 * 
 * </pre>
 * 
 * @date : Oct 30, 2019
 * @version :
 * @author : hschoi
 */
@Component
public class FileReader {

	private final Logger log = LoggerFactory.getLogger(FileReader.class);

	public FileHandler read() {

		try {

			ClassPathResource cpr = new ClassPathResource("data.csv");

			BufferedReader input = new BufferedReader(
					new InputStreamReader(cpr.getInputStream(), StandardCharsets.UTF_8));
			log.info("File Read Start");
			List<DeviceType> deviceNames = getHeader(input.readLine());
			log.info("devices: {} ", deviceNames);
			List<String> body = readBody(input);
			log.info("body: {} ", body);

			return new FileHandler(deviceNames, body);
		} catch (IOException e) {
			log.error("FAIL_FILE_READ", e);
			throw new CustomException(FAIL_FILE_READ);
		}
	}

	public List<DeviceType> getHeader(String row) {
		String[] headers = parseHeader(row);
		List<DeviceType> deviceNames = new ArrayList<>();
		for (int i = 2; i < headers.length; i++) {
			log.info("FileHandler >>> getHeader headers: {} ", headers[i]);
			deviceNames.add(DeviceType.is(headers[i]));
		}
		return deviceNames;
	}
	
	public String[] parseHeader(String row) {
        String[] splitedDatas = row.split(",");
        return Arrays.stream(splitedDatas).filter( data -> data.length() > 0 ).toArray(String[]::new);
    }
	
	public List<String> readBody(BufferedReader input) {
        return input.lines().map( rowdata -> removeCommaBetweenQuotes(rowdata) ).collect(Collectors.toList());
    }
	
	public String removeCommaBetweenQuotes(String line) {
		int charCount = 0;
		char[] charArray = line.toCharArray();
		StringBuilder newLine = new StringBuilder();

		for (char c : charArray) {
			if (c == '"') {
				charCount++;
				newLine.append(c);
			}
			else if (charCount % 2 == 1 && c == ',') {
				// do nothing
			}
			else {
				newLine.append(c);
			}
		}
		return newLine.toString().replaceAll("\"", "");
	}
}
