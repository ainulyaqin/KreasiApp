package com.kreasi.app.dto;

import com.kreasi.app.util.ResponseCode;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseData<T> extends ResponseTemplate {

	private T data;
	
	public ResponseData() {
		super(ResponseCode.OK.toString(), ResponseCode.OK.code, ResponseCode.OK.message);
	}
	
	public ResponseData(T data) {
		super(ResponseCode.OK.toString(), ResponseCode.OK.code, ResponseCode.OK.message);
		this.data=data;
	}
	
	public ResponseData(String status, Integer code, String message) {
		super(status, code, message);
	}
	
}
