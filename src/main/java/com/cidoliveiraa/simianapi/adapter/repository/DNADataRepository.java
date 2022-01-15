package com.cidoliveiraa.simianapi.adapter.repository;

import java.util.List;

import com.cidoliveiraa.simianapi.adapter.repository.model.DNA;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DNADataRepository extends MongoRepository<DNA, Long> {
  DNA findBySequence(List<String> sequence);
}
