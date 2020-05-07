package com.davidbharrison.restfun.num_to_english.controller;

import com.davidbharrison.restfun.num_to_english.model.NumToEnglishRequest;
import com.davidbharrison.restfun.num_to_english.model.NumToEnglishResponse;
import com.davidbharrison.restfun.num_to_english.service.NumToEnglishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@RequestMapping(value="num_to_english", produces="application/json")
public class NumToEnglishController {
    NumToEnglishService numToEnglishService;

    @Autowired
    public NumToEnglishController(NumToEnglishService numToEnglishService) {
        this.numToEnglishService = numToEnglishService;
    }

    // TODO Change value to /num_to_english
    @GetMapping(value="/nte1", produces = {"application/json"})
    public NumToEnglishResponse getConversion(NumToEnglishRequest req) {
        log.info("getConversion "+req.toString());
        // rfc2616, section-4.3
        return numToEnglishService.converNumToEnglish(req.getNumber());
    }

    // TODO Change value to /num_to_english
    @PostMapping(value="/nte2", produces = {"application/json"})
    public NumToEnglishResponse postConversion(NumToEnglishRequest req) {
        log.info("postConversion "+req.toString());
        return NumToEnglishResponse.builder()
                .status("ok")
                .numInEnglish(req.getNumber())
                .build();
    }
}
