package com.vksk.Enotes_Api_Service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNOtFoundException(Exception e) {
		log.error("resourceNOtFoundException called and message : {}", e.getMessage());
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(Exception e) {
		log.error("handleIllegalArgumentException called and message : {}", e.getMessage());
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<?> handleValidationException(ValidationException e) {
		log.error("handleValidationException called and message : {}", e.getMessage());
		return new ResponseEntity<>(e.getError(), HttpStatus.NOT_FOUND);
	}

}
