package com.example.auth.util;

import java.util.HashMap;
import java.util.Map;

public class UrlUtil {
	public static class UrlEntity {
		/**
		 * 基础url
		 */
		private String baseUrl;
		/**
		 * url参数
		 */
		private Map<String, String> params;

		public String getBaseUrl() {
			return baseUrl;
		}

		public Map<String, String> getParams() {
			return params;
		}
	}

	/**
	 * 解析url
	 *
	 * @param url
	 * @return
	 */
	public static UrlEntity parse(String url) {
		UrlEntity entity = new UrlEntity();
		if (url == null) {
			return entity;
		}
		url = url.trim();
		if (url.equals("")) {
			return entity;
		}
		String[] urlParts = url.split("\\?");
		entity.baseUrl = urlParts[0];
		//没有参数
		if (urlParts.length == 1) {
			return entity;
		}
		//有参数
		String[] params = urlParts[1].split("&");
		entity.params = new HashMap<>();
		for (String param : params) {
			String[] keyValue = param.split("=");
			entity.params.put(keyValue[0], keyValue[1]);
		}

		return entity;
	}
}
