package com.cidoliveiraa.simianapi.adapter.controller.response;

import org.springframework.http.HttpStatus;

public record ApiErrorResponse(HttpStatus status, String message) {
}
