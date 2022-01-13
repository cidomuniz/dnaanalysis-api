package com.cidoliveiraa.simianapi.controllers;

import com.cidoliveiraa.simianapi.controllers.request.SimianVerificationRequest;
import com.cidoliveiraa.simianapi.controllers.response.SimianStatsResponse;
import com.cidoliveiraa.simianapi.controllers.response.SimianVerificationResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimianController {
  
  @PostMapping("/simian")
  public SimianVerificationResponse verifySimian(@RequestBody SimianVerificationRequest request) {
    return new SimianVerificationResponse(null);
  }

  @GetMapping("/stats")
  public SimianStatsResponse stats() {
    return new SimianStatsResponse(0, 0, 0.0);
  }

}
