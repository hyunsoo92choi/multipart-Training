package com.hschoi.multipart.common.code.mapper;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <pre>
 * com.hschoi.multipart.common.code.mapper_EnumMapper.java
 * 
 * </pre>
 * @date : Oct 30, 2019 
 * @author : hschoi
 */
public class EnumMapper {
	public EnumMapper() {};

	private Map<String, List<EnumValue>> factory = new LinkedHashMap<>();

	public void put(String key, Class<? extends EnumType> e) {
		factory.put(key, toEnumValues(e));
	}

	private List<EnumValue> toEnumValues(Class<? extends EnumType> e) {
		return Arrays.stream(e.getEnumConstants()).map(EnumValue::new).collect(Collectors.toList());
	}

	public List<EnumValue> get(String key) {
		return factory.get(key);
	}

	public Map<String, List<EnumValue>> get(List<String> keys) {
		if (keys == null || keys.size() == 0) {
			return new LinkedHashMap<>();
		}

		return keys.stream().collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
	}

	public Map<String, List<EnumValue>> getAll() {
		return factory;
	}
}
