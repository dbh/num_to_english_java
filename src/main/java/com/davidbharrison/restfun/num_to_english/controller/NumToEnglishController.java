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


    @GetMapping(value="/num_to_english_better", produces = {"application/json"})
    public NumToEnglishResponse getConversionBetter(@RequestParam String number) {
        log.info("getConversion the right way "+number);
        return numToEnglishService.converNumToEnglish(number);
    }

    @GetMapping(value="/num_to_english", produces = {"application/json"})
    public NumToEnglishResponse getConversion(@RequestBody NumToEnglishRequest req) {
        log.info("getConversion "+req.toString());
        // rfc2616, section-4.3
        // Illegal per HTTP spec, but technically possible. Don't use GET to send a Payload...
        // if you must use a GET, perhaps put the number on the URL as a parameter
        return numToEnglishService.converNumToEnglish(req.getNumber());
    }

    @PostMapping(value="/num_to_english", produces = {"application/json"})
    public NumToEnglishResponse postConversion(@RequestBody  NumToEnglishRequest req) {
        log.info("postConversion "+req.toString());
        return numToEnglishService.converNumToEnglish(req.getNumber());
    }
}
