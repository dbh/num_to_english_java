package com.davidbharrison.restfun.num_to_english.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumToEnglishResponse {
    @JsonProperty
    private String status;

    @JsonProperty("num_in_english")
    private String numInEnglish;
}
