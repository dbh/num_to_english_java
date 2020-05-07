package com.davidbharrison.restfun.num_to_english.service;

import com.davidbharrison.restfun.num_to_english.model.NumToEnglishRequest;
import com.davidbharrison.restfun.num_to_english.model.NumToEnglishResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NumToEnglishService {
    public NumToEnglishService() {
        log.info("Constructor");
    }
    public NumToEnglishResponse converNumToEnglish(String req) {
        return NumToEnglishResponse.builder()
                .status("ok")
                .numInEnglish("TODO convert req "+ req)
                .build();
    }
}
