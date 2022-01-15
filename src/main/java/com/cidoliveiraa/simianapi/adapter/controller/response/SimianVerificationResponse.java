package com.cidoliveiraa.simianapi.adapter.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SimianVerificationResponse(@JsonProperty("is_simian") boolean isSimian) {
}
