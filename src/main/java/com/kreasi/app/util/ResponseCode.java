package com.kreasi.app.util;

import org.springframework.http.HttpStatus;

public enum ResponseCode {

	OK(HttpStatus.OK.value(),10000,"Success !"),
	BAD_REQUEST(HttpStatus.BAD_REQUEST.value(),30001,"Invalid value for field <FIELD_NAME>, caused by: "),
	CONFLICT(HttpStatus.CONFLICT.value(),30002,"Record with SSN <SSN_NUMBER> already exists in the system"),
	NOT_FOUND(HttpStatus.NOT_FOUND.value(),30000,"No such resource with id <THE_ID>"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),20000,"Oops, something wents wrong..");
;

	public final Integer httpCode;
	
	public final Integer code;
	
	public final String message;

    private ResponseCode(Integer httpCode, Integer code, String message) {
        this.httpCode=httpCode;
        this.code=code;
        this.message=message;
    }
	
	
}
