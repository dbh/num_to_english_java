package com.davidbharrison.restfun.num_to_english.controller;

import com.davidbharrison.restfun.num_to_english.model.NumToEnglishRequest;
import com.davidbharrison.restfun.num_to_english.model.NumToEnglishResponse;
import com.davidbharrison.restfun.num_to_english.service.NumToEnglishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@RequestMapping(value="num_to_english", produces="application/json")
public class NumToEnglishController {
    NumToEnglishService numToEnglishService;

    @Autowired
    public NumToEnglishController(NumToEnglishService numToEnglishService) {
        this.numToEnglishService = numToEnglishService;
    }

    @GetMapping(value="/num_to_english", produces = {"application/json"})
    public NumToEnglishResponse getConversion(@RequestBody NumToEnglishRequest req) {
        log.info("GET num_to_english getConversion "+req.toString());
        // It's bad practice and not guaranteed to be supported to send a message
        // body on a GET request. If you must use a GET, perhaps put the number on the
        // URL as a parameter. See /num_to_english_param instead.
        return numToEnglishService.converNumToEnglish(req.getNumber());
    }

    @GetMapping(value="/num_to_english_param", produces = {"application/json"})
    public NumToEnglishResponse getConversionBetter(@RequestParam String number) {
        log.info("GET num_to_english_param getConversion the right way "+number);
        // This wasn't explicitly requested, but it is better practice.
        return numToEnglishService.converNumToEnglish(number);
    }

    @PostMapping(value="/num_to_english", produces = {"application/json"})
    public NumToEnglishResponse postConversion(@RequestBody  NumToEnglishRequest req) {
        log.info("POST num_to_english postConversion "+req.toString());
        // Also this wasn't requested, but is a correct way to send a message body for processing
        // However, a POST, can be misleading because this request is not actually creating a new
        // entity, but rather just passing data for transformation and getting it back
        return numToEnglishService.converNumToEnglish(req.getNumber());
    }
}
