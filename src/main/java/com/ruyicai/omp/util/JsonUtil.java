package com.ruyicai.omp.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * JSON转换工具类
 */
public class JsonUtil {

	/**
	 * json字符串转换为Map<String,Object>格式
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> transferJson2Map(String json) {
		if (StringUtils.isBlank(json)) {
			return new HashMap<String, Object>();
		}
		Map<String, Object> result = new JSONDeserializer<Map<String, Object>>().use(null,
				new HashMap<String, Object>().getClass()).deserialize(json);
		return result;
	}

	public static String toJson(Map map) {
		try {
			return new JSONSerializer().serialize(map);
		} catch (Exception e) {
//			throw new RuyicaiException("toJson error", e);
			e.printStackTrace();
		}
		return null;
	}
	
	public static String toJson(List list) {
		try {
			return new JSONSerializer().exclude("*.class").serialize(list);
		} catch (Exception e) {
//			throw new RuyicaiException("toJson error", e);
			e.printStackTrace();
		}
		return null;
	}
	
}
