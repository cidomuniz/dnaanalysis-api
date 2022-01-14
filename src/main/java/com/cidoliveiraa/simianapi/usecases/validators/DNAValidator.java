package com.cidoliveiraa.simianapi.usecases.validators;

import java.util.List;

import com.cidoliveiraa.simianapi.exceptions.InvalidDNAException;

public class DNAValidator {
  public static void validateDNASequence(List<String> dna) throws InvalidDNAException {
    if (dna == null || dna.isEmpty()) {
      throw new InvalidDNAException("Lista de DNA vazia.");
    }
    if (dna.stream().anyMatch(dnaString -> dnaString.length() != dna.size() || !dnaString.matches("^[ATCG]*$"))) {
      throw new InvalidDNAException(
          "Lista de DNA inválida, verifique se a lista representa uma tabela quadrada (NxN), ou contém algum caractere diferente de (A, T, C, G).");
    }
  }

  private DNAValidator() {
  }
}
