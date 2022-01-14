package com.cidoliveiraa.simianapi.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SimianUseCase {
  
  public boolean verifySimian(List<String> dna) {
    validateDnaMatrix(dna);
    return true;
  }

  private void validateDnaMatrix(List<String> dna) {
    if (dna == null || dna.isEmpty()) {
      throw new IllegalArgumentException("Lista de DNA vazia.");
    }
    if (dna.stream().anyMatch(dnaString -> dnaString.length() != dna.size() || !dnaString.matches("^[ATCG]*$"))) {
      throw new IllegalArgumentException("Lista de DNA inválida, verifique se a lista representa uma tabela quadrada (NxN), ou contém algum caractere diferente de (A, T, C, G).");
    }
  }
}
