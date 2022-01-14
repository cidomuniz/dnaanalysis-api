package com.cidoliveiraa.simianapi.adapter.repository.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record DNA(@Id String id, List<String> sequence, boolean isSimian) {}
