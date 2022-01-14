package com.cidoliveiraa.simianapi.controllers.response;

import org.springframework.http.HttpStatus;

public record ApiErrorResponse(HttpStatus status, String message) {
}
