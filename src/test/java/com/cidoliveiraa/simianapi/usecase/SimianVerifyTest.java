package com.cidoliveiraa.simianapi.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.cidoliveiraa.simianapi.domain.entity.DNA;
import com.cidoliveiraa.simianapi.domain.exception.InvalidDNAException;
import com.cidoliveiraa.simianapi.usecase.port.DNARepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimianVerifyTest {

  @Mock
  private DNARepository dnaRepository;

  @InjectMocks
  private SimianVerify simianVerify;

  @Test
  public void givenDNASimian_whenVerify_thenReturnTrue() throws InvalidDNAException {
    List<String> dnaSequence = Arrays
        .asList(new String[] { "CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG" });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertTrue(simianVerify.verify(dna));
  }

  @Test
  public void givenDNASimianMatchedDiagonallyFromLeft_whenVerify_thenReturnTrue() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "AATTGCTTCCGG", "CAAGGCTAGCGA", "GATACGATCGCT", "AGCTTAGTCAGA", "TCGAGACTGTCT",
            "CATCTGAATCGA", "GTAGACGAAGCT", "GATTACCAATTT", "CTAATGGTTAAA", "CGATCGATGACT", "GCTAGCAACTGA"
        });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertTrue(simianVerify.verify(dna));
  }

  @Test
  public void givenDNASimianMatchedDiagonallyFromLeftUpSide_whenVerify_thenReturnTrue() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] {"AAATCGACGGCC","ACTGGCTTCCGG","CAAGGCTAGCGA","GATACGATCGCT","AGCTCAGTCAGA","TCGAGTCAGTCT","CATCTGCATCGA","GTAGACGTAGCT","GATTACCAATTT","CTAATGGTTAAA","CGATCGATGACT","GCTAGCAACTGA"
        });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertTrue(simianVerify.verify(dna));
  }

  @Test
  public void givenDNASimianMatchedDiagonallyFromLeftDownSide_whenVerify_thenReturnTrue() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "ACTTGCTTCCGG", "CAAGGCTAGCGA", "GATACGATCGCT", "AGCTCAGTCAGA", "TCGAGTCAGTCT",
            "CATGTGCATCGA", "GTAGACGTAGCT", "GTTTACCAATTT", "CTTATGGTTAAA", "CGATCGATGACT", "GCTATCAACTGA" });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertTrue(simianVerify.verify(dna));
  }

  @Test
  public void givenDNASimianMatchedDiagonallyFromRight_whenVerify_thenReturnTrue() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "ACTTGCTTCCCG", "CAAGGCTAGCGA", "GATACGATCGCT", "AGCTCAGTCAGA", "TCGAGTTAGTCT",
            "CATCTTCATCGA", "GTAGTCGTAGCT", "GATTACCAATTT", "CTAATGGTTAAA", "CGATCGATGACT", "GCTAGCAACTGA"
        });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertTrue(simianVerify.verify(dna));
  }

  @Test
  public void givenDNASimianMatchedDiagonallyFromRightUpSide_whenVerify_thenReturnTrue() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "ACTTGCTTCCGG", "CAAGGCTAGCGA", "GAGACGATCGCT", "AGCCCAGTCAGA", "TCCAGTCAGTCT",
            "CATCTGCATCGA", "GTAGACGTAGCT", "GATTACCAATTT", "CTAATGGTTAAA", "CGATCGATGACT", "GCTAGCAACTGA"
        });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertTrue(simianVerify.verify(dna));
  }
  
  @Test
  public void givenDNASimianMatchedDiagonallyFromRightDownSide_whenVerify_thenReturnTrue() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] {"AAATCGAAGGCC", "ACTTGCTTCCGG", "CAAGGCTAGCGA", "GATACGATCGCT", "AGCTCAGTCAGA", "TCGAGTCAGTCT","CATCTGCATCGA", "GTAGACGTCGCT", "GATTACCCATTT", "CTAATGGTTAAA", "CGATCGATGACT", "GCTAGCTACTGA"
        });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);
  
    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertTrue(simianVerify.verify(dna));

  }

  @Test
  public void givenDNASimianMatchedHorizontally_whenVerify_thenReturnTrue() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "ACTTGCTTCCGG", "CAAGGCTAGCGA", "GATACGATCGCT", "AGCTCAGTCAGA", "TCGAGTCAGTCT",
            "CATCTGCATCGA", "GTAGACGTAGCT", "GATTACCAATTT", "CTAATGGTTAAA", "CGATCGATGACT", "GGGGGGGGCTGA"
        });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertTrue(simianVerify.verify(dna));
  }

  @Test
  public void givenDNASimianMatchedVertically_whenVerify_thenReturnTrue() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "ACTTGCTTCCGG", "AAAGGCTAGCGA", "AATACGATCGCT", "AGCTCAGTCAGA", "ACGAGTCAGTCT",
            "AATCTGCATCGA", "ATAGACGTAGCT", "GATTACCAATTT", "CTAATGGTTAAA", "CGATCGATGACT", "GCTAGCAACTGA" });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertTrue(simianVerify.verify(dna));
  }

  @Test
  public void givenDNAHuman_whenVerify_thenReturnFalse() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "ACTTGCTTCCGG", "CAAGGCTAGCGA", "GATACGATCGCT", "AGCTCAGTCAGA", "TCGAGTCAGTCT",
            "CATCTGCATCGA", "GTAGACGTAGCT", "GATTACCAATTT", "CTAATGGTTAAA", "CGATCGATGACT", "GCTAGCTACTGA" });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    assertFalse(simianVerify.verify(dna));
  }

  @Test
  public void givenDNAAlreadyVerified_whenVerify_thenReturnFalse() throws InvalidDNAException {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "ACTTGCTTCCGG", "CAAGGCTAGCGA", "GATACGATCGCT", "AGCTCAGTCAGA", "TCGAGTCAGTCT",
            "CATCTGCATCGA", "GTAGACGTAGCT", "GATTACCAATTT", "CTAATGGTTAAA", "CGATCGATGACT", "GCTAGCTACTGA" });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);
    dna.setSimian(false);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(dna);
    assertFalse(simianVerify.verify(dna));
  }

  @Test
  public void givenDNASequenceNull_whenVerify_thenReturnInvalidDNAException() {
    DNA dna = new DNA();

    when(dnaRepository.findBySequence(dna.getSequence())).thenReturn(new DNA());
    InvalidDNAException thrown = assertThrows(InvalidDNAException.class, () -> {
      simianVerify.verify(dna);
    });
    assertEquals(
        "Lista de DNA vazia.",
        thrown.getMessage());
  }

  @Test
  public void givenDNASequenceMatrixNotNxN_whenVerify_thenReturnInvalidDNAException() {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "ACTTGCTTCCGG", "CAAGGCTAGCGA", "GATACGATCGCT", "AGCTCAGTCAGA", "TCGAGTCAGTCT",
            "CATCTGCATCGA", "GTAGACGTAGCT", "GATTACCAATTT", "CTAATGGTTAAAA", "CGATCGATGACT", "GCTAGCTACTGA" });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    InvalidDNAException thrown = assertThrows(InvalidDNAException.class, () -> {
      simianVerify.verify(dna);
    });
    assertEquals(
        "Lista de DNA inválida, verifique se a lista representa uma tabela quadrada (NxN), ou contém algum caractere diferente de (A, T, C, G).",
        thrown.getMessage());
  }

  @Test
  public void givenDNASequenceWithInvalidCharacters_whenVerify_thenReturnInvalidDNAException() {
    List<String> dnaSequence = Arrays.asList(
        new String[] { "AAATCGAAGGCC", "ACTTGCTTCCGG", "CAAGGCTAGCGA", "GATACGATCGCT", "AGCTCAGTCAGA", "TCGAGTCAGTCT",
            "CATCTGCATCGA", "GTAGACGTAGCX", "GATTACCAATTT", "CTAATGGTTAAA", "CGATCGATGACT", "GCTAGCAACTGA" });
    DNA dna = new DNA();
    dna.setSequence(dnaSequence);

    when(dnaRepository.findBySequence(dnaSequence)).thenReturn(new DNA());
    InvalidDNAException thrown = assertThrows(InvalidDNAException.class, () -> {
      simianVerify.verify(dna);
    });
    assertEquals(
        "Lista de DNA inválida, verifique se a lista representa uma tabela quadrada (NxN), ou contém algum caractere diferente de (A, T, C, G).",
        thrown.getMessage());
  }
}
