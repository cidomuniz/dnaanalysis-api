package com.cidoliveiraa.simianapi.usecase;

import com.cidoliveiraa.simianapi.domain.entity.DNA;
import com.cidoliveiraa.simianapi.domain.exception.InvalidDNAException;

import org.springframework.stereotype.Component;

@Component
public class VerifySimian {
  
  public boolean verify(DNA dna) throws InvalidDNAException {
    dna.validateSequence();
    return true;
  }
}
