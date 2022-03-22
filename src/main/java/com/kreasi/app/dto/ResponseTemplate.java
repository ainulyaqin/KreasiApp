package com.kreasi.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class ResponseTemplate {

	private String message;
    private String status;
    private Integer code;
    
    public ResponseTemplate(String status, Integer code, String message) {
    	this.message=message;
    	this.status=status;
    	this.code=code;
    }
}
