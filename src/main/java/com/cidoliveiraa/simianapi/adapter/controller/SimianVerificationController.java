package com.cidoliveiraa.simianapi.adapter.controller;

import com.cidoliveiraa.simianapi.adapter.controller.request.SimianVerificationRequest;
import com.cidoliveiraa.simianapi.adapter.controller.response.SimianVerificationResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simian")
public class SimianVerificationController {
  
  @PostMapping
  public SimianVerificationResponse verifySimian(@RequestBody SimianVerificationRequest request) {
    return new SimianVerificationResponse(null);
  }

}
