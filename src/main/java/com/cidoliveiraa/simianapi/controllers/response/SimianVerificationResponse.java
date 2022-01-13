package com.cidoliveiraa.simianapi.controllers.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SimianVerificationResponse(@JsonProperty("is_simian") String isSimian) {
}
