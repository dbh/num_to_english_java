package com.davidbharrison.restfun.num_to_english.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NumToEnglishRequest {
    @JsonProperty
    String number;
}
