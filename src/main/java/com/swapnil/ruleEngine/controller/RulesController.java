package com.swapnil.ruleEngine.controller;

import com.swapnil.ruleEngine.model.Rule;
import com.swapnil.ruleEngine.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/rules")
public class RulesController {
    @Autowired
    private RulesService rulesService;

    @GetMapping("/")
    public Flux<Rule> getAllRules() {

        return rulesService.getAllRules();

    }


}
