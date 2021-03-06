package com.cidoliveiraa.simianapi.adapter.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SimianStatsResponse(@JsonProperty("count_simian_dna") int countSimianDna,
    @JsonProperty("count_human_dna") int countHumanDna, double ratio) {
}
