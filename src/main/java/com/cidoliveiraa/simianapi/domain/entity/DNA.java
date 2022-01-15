package com.cidoliveiraa.simianapi.domain.entity;

import java.util.List;

import com.cidoliveiraa.simianapi.domain.exception.InvalidDNAException;

public record DNA(List<String> sequence) {

  public void validateSequence() throws InvalidDNAException {
    if (this.sequence == null || this.sequence.isEmpty())
      throw new InvalidDNAException("Lista de DNA vazia.");
    if (this.sequence.stream().anyMatch(sequence -> sequence.length() != this.sequence.size() || !sequence.matches("^[ATCG]*$")))
      throw new InvalidDNAException(
          "Lista de DNA inválida, verifique se a lista representa uma tabela quadrada (NxN), ou contém algum caractere diferente de (A, T, C, G).");
  }
}

