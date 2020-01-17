package com.example.auth.token;

import com.example.auth.util.MD5Util;

import java.time.Duration;
import java.time.Instant;

public class AuthToken {
	private static final long DEFAULT_TIME_INTERVAL = 1 * 60 * 1000;

	private String token;

	private long createTime;

	private long expiredTimeInterval = DEFAULT_TIME_INTERVAL;

	public AuthToken(String token, long createTime) {
		this.token = token;
		this.createTime = createTime;
	}

	public AuthToken(String token, long createTime, long expiredTimeInterval) {
		this.token = token;
		this.createTime = createTime;
		this.expiredTimeInterval = expiredTimeInterval;
	}

	public static AuthToken generate(String originalUrl, String appId, String password, long timestamp) {
		String token = MD5Util.md5(originalUrl + appId + password + timestamp);
		return new AuthToken(token, timestamp);
	}

	public String getToken() {
		return token;
	}

	public boolean isExpired() {
		Instant expiredTime = Instant.ofEpochMilli(createTime).plusMillis(expiredTimeInterval);
		if (Duration.between(Instant.now(), expiredTime).isNegative()) {
			return false;
		}
		return true;
	}

	public boolean match(AuthToken authToken) {
		return token.equals(authToken.getToken());
	}
}
