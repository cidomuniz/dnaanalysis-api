package com.cidoliveiraa.simianapi.adapter.repository;

import java.util.List;

import com.cidoliveiraa.simianapi.adapter.repository.mapper.DNAMapper;
import com.cidoliveiraa.simianapi.domain.entity.DNA;
import com.cidoliveiraa.simianapi.usecase.port.DNARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultDNARepository implements DNARepository {
  @Autowired
  private DNADataRepository repository;

  @Autowired
  private DNAMapper dnaMapper;

  @Override
  public DNA findBySequence(List<String> sequence) {
    return dnaMapper.map(repository.findBySequence(sequence), DNA.class);
  }

  @Override
  public DNA save(DNA dna) {
    return dnaMapper.map(
        repository.save(dnaMapper.map(dna, com.cidoliveiraa.simianapi.adapter.repository.model.DNA.class)),
        DNA.class);
  }
}
