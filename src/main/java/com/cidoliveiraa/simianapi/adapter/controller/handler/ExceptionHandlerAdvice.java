package com.cidoliveiraa.simianapi.adapter.controller.handler;

import com.cidoliveiraa.simianapi.adapter.controller.response.ApiErrorResponse;
import com.cidoliveiraa.simianapi.domain.exception.InvalidDNAException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
  private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

  @ExceptionHandler(InvalidDNAException.class)
  public ResponseEntity<ApiErrorResponse> handleDNAInvalidException(Exception e) {
    return sendError(HttpStatus.BAD_REQUEST, e);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiErrorResponse> handleRandomException(Exception e) {
    return sendError(HttpStatus.INTERNAL_SERVER_ERROR, e);
  }

  private ResponseEntity<ApiErrorResponse> sendError(HttpStatus status, Exception e) {
    logger.error("ErrorHandler - Status: {}, Message: {}", status, e.getMessage(), e);
    return new ResponseEntity<>(new ApiErrorResponse(status, e.getMessage()), status);
  }

}
