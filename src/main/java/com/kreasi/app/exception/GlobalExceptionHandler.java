package com.kreasi.app.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.kreasi.app.dto.ResponseData;
import com.kreasi.app.dto.ResponseTemplate;
import com.kreasi.app.util.ResponseCode;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseTemplate> globalExceptionHandler(Exception ex, WebRequest request) {

		log.error("Error from the api Exception {}", ex);

		ResponseTemplate rt = new ResponseData<String>(ResponseCode.INTERNAL_SERVER_ERROR.toString(),ResponseCode.NOT_FOUND.code,ResponseCode.INTERNAL_SERVER_ERROR.message);
		
		return new ResponseEntity<ResponseTemplate>(rt,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseTemplate> dataNotFoundException(Exception ex, WebRequest request) {

		log.error("Error from the api DataNotFoundException {} ", ex.getMessage());

		String msg = ResponseCode.NOT_FOUND.message;
		try {
			String id = ex.getMessage().split("@")[0];
			msg = msg.replace("<THE_ID>",id);
		} catch (Exception e) {
			log.error(e);
		}
		
		ResponseTemplate rt = new ResponseData<String>(ResponseCode.NOT_FOUND.toString(),ResponseCode.NOT_FOUND.code,msg);
		
		return new ResponseEntity<ResponseTemplate>(rt,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ResponseTemplate> ConflictException(Exception ex, WebRequest request) {

		log.error("Error from the api DataNotFoundException {} ", ex.getMessage());

		String msg = ResponseCode.CONFLICT.message;
		try {
			String id = ex.getMessage().split("@")[0];
			msg = msg.replace("<SSN_NUMBER>",id);
		} catch (Exception e) {
			log.error(e);
		}
		
		ResponseTemplate rt = new ResponseData<String>(ResponseCode.CONFLICT.toString(),ResponseCode.CONFLICT.code,msg);
		
		return new ResponseEntity<ResponseTemplate>(rt,HttpStatus.CONFLICT);
		
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<ResponseTemplate> ValidateException(BindException ex, WebRequest request) {

		log.error("Error from the api ValidateException {}", ex.getMessage());

		List<ObjectError> err = ex.getBindingResult().getAllErrors();
		
		String msg = ResponseCode.BAD_REQUEST.message;
		
		for(ObjectError e : err) {
			String fieldName = ((FieldError) e).getField();
			msg = msg.replace("<FIELD_NAME>", fieldName).concat(e.getDefaultMessage());
			break;
		}
		
		ResponseTemplate rt = new ResponseData<String>(ResponseCode.BAD_REQUEST.toString(),ResponseCode.BAD_REQUEST.code,msg);
		
		return new ResponseEntity<ResponseTemplate>(rt,HttpStatus.BAD_REQUEST);
	}

}
