package com.cidoliveiraa.simianapi.usecase.port;

import java.util.List;

import com.cidoliveiraa.simianapi.domain.entity.DNA;

public interface DNARepository {
  public DNA findBySequence(List<String> sequence);
  public DNA save(DNA dna);
  public int countAllSimian();
  public int countAllHuman();
}
