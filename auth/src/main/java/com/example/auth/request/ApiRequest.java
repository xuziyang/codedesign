package com.example.auth.request;

import com.example.auth.util.UrlUtil;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;

public class ApiRequest {

	private String originalUrl;
	private String token;
	private String appId;
	private long timestamp;

	public ApiRequest(String originalUrl, String token, String appId, long timestamp) {
		this.originalUrl = originalUrl;
		this.token = token;
		this.appId = appId;
		this.timestamp = timestamp;
	}

	public static ApiRequest buildFromUrl(String url) {
		UrlUtil.UrlEntity urlEntity = UrlUtil.parse(url);
		Map<String, String> params = urlEntity.getParams();
		return new ApiRequest(urlEntity.getBaseUrl(), params.get("token"), params.get("appId"),
				MapUtils.getLong(params, "timestamp"));
	}



	public String getOriginalUrl() {
		return originalUrl;
	}

	public String getToken() {
		return token;
	}

	public String getAppId() {
		return appId;
	}

	public long getTimestamp() {
		return timestamp;
	}
}
