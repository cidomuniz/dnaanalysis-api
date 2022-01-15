package com.cidoliveiraa.simianapi.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.cidoliveiraa.simianapi.domain.entity.Stats;
import com.cidoliveiraa.simianapi.usecase.port.DNARepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DNAStatsTest {

  @Mock
  private DNARepository dnaRepository;

  @InjectMocks
  private DNAStats dnaStats;
  
  @Test
  public void givenNothing_whenCollect_thenReturnStats() {
    int countHumanDNA = 100;
    int countSimianDNA = 40;
    double ratio = 0.4;
    Stats stats = new Stats(countSimianDNA, countHumanDNA, ratio);

    when(dnaRepository.countAllHuman()).thenReturn(countHumanDNA);
    when(dnaRepository.countAllSimian()).thenReturn(countSimianDNA);

    assertEquals(stats, dnaStats.collect());
  }
}
