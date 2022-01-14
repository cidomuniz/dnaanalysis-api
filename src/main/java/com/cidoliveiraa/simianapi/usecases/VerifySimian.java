package com.cidoliveiraa.simianapi.usecases;

import java.util.List;

import com.cidoliveiraa.simianapi.exceptions.InvalidDNAException;
import com.cidoliveiraa.simianapi.usecases.validators.DNAValidator;

import org.springframework.stereotype.Component;

@Component
public class VerifySimian {
  
  public boolean verify(List<String> dna) throws InvalidDNAException {
    DNAValidator.validateDNASequence(dna);
    return true;
  }
}
