package com.cidoliveiraa.simianapi.usecase;

import com.cidoliveiraa.simianapi.domain.entity.Stats;
import com.cidoliveiraa.simianapi.usecase.port.DNARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DNAStats {
  @Autowired
  private DNARepository dnaRepository;

  public Stats collect() {
    int simianCount = dnaRepository.countAllSimian();
    int humanCount = dnaRepository.countAllHuman();
    double ratio = (double) simianCount / humanCount;
    return new Stats(simianCount, humanCount, ratio);
  }
  
}
