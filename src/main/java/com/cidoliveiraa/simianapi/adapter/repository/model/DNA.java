package com.cidoliveiraa.simianapi.adapter.repository.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("dna")
public class DNA {
  @Id
  private String id;
  private List<String> sequence;
  private boolean isSimian;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<String> getSequence() {
    return sequence;
  }

  public void setSequence(List<String> sequence) {
    this.sequence = sequence;
  }

  public boolean isSimian() {
    return isSimian;
  }

  public void setSimian(boolean isSimian) {
    this.isSimian = isSimian;
  }
}
