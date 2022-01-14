package com.cidoliveiraa.simianapi.adapter.controller;

import com.cidoliveiraa.simianapi.adapter.controller.response.SimianStatsResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

  @GetMapping
  public SimianStatsResponse stats() {
    return new SimianStatsResponse(0, 0, 0.0);
  }
}
