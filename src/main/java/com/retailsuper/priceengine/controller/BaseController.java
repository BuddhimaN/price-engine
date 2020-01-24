package com.retailsuper.priceengine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Base Controller
 * @author BuddhimaN
 * @since 01/20
 */

@RestController
public class BaseController {
    @GetMapping(value = "/")
    public String index() {
        return "Welcome to Retail Super Price Engine";
    }
}
