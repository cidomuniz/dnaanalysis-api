package com.cidoliveiraa.simianapi.controllers.request;

import java.util.List;

public record SimianVerificationRequest(List<String> dna) {
}
