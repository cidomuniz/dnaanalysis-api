package com.cidoliveiraa.simianapi.adapter.controller;

import com.cidoliveiraa.simianapi.adapter.controller.request.SimianVerificationRequest;
import com.cidoliveiraa.simianapi.adapter.controller.response.SimianVerificationResponse;
import com.cidoliveiraa.simianapi.domain.entity.DNA;
import com.cidoliveiraa.simianapi.domain.exception.InvalidDNAException;
import com.cidoliveiraa.simianapi.usecase.VerifySimian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simian")
public class SimianVerificationController {
  @Autowired
  private VerifySimian verifySimian;


  @PostMapping
  public SimianVerificationResponse verifySimian(@RequestBody SimianVerificationRequest request) throws InvalidDNAException {
    DNA dna = new DNA();
    dna.setSequence(request.dna());
    return new SimianVerificationResponse(verifySimian.verify(dna));
  }

}
