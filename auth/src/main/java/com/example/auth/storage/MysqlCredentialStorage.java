package com.example.auth.storage;

public class MysqlCredentialStorage implements CredentialStorage{
	@Override
	public String getPasswordById(String appId) {
		return "123456";
	}
}
