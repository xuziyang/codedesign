package com.example.auth;

import com.example.auth.request.ApiRequest;

public interface ApiAuthenticator {

	void auth(String url);

	void auth(ApiRequest apiRequest);

}
