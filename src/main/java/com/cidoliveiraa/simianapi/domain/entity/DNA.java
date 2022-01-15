package com.cidoliveiraa.simianapi.domain.entity;

import java.util.List;

import com.cidoliveiraa.simianapi.domain.exception.InvalidDNAException;

public class DNA {
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

  public void validateSequence() throws InvalidDNAException {
    if (this.sequence == null || this.sequence.isEmpty())
      throw new InvalidDNAException("Lista de DNA vazia.");
    if (this.sequence.stream().anyMatch(str -> str.length() != this.sequence.size() || !str.matches("^[ATCG]*$")))
      throw new InvalidDNAException(
          "Lista de DNA inválida, verifique se a lista representa uma tabela quadrada (NxN), ou contém algum caractere diferente de (A, T, C, G).");
  }

  public boolean isEmpty() {
    return id == null && sequence == null;
  }

}

