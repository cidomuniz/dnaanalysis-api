package com.cidoliveiraa.simianapi.adapter.controller;

import com.cidoliveiraa.simianapi.adapter.controller.response.SimianStatsResponse;
import com.cidoliveiraa.simianapi.domain.entity.Stats;
import com.cidoliveiraa.simianapi.usecase.DNAStats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

  @Autowired
  private DNAStats dnaStats;

  @GetMapping
  public SimianStatsResponse stats() {
    Stats stats = dnaStats.collect();
    return new SimianStatsResponse(stats.countSimianDna(), stats.countHumanDna(), stats.ratio());
  }
}
