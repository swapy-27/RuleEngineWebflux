package com.swapnil.ruleEngine.controller;

import com.swapnil.ruleEngine.model.LoanDetails;
import com.swapnil.ruleEngine.model.Rule;
import com.swapnil.ruleEngine.model.UserDetails;
import com.swapnil.ruleEngine.rulesengine.LoanInferenceEngine;
import com.swapnil.ruleEngine.rulesengine.RuleEngine;
import com.swapnil.ruleEngine.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RulesController {
    @Autowired
    private RulesService rulesService;

    @Autowired
    private RuleEngine ruleEngine;
    @Autowired
    private LoanInferenceEngine loanInferenceEngine;
    @GetMapping("/")
    public Flux<Rule> getAllRules() {

        return rulesService.getAllRules();

    }

    @PostMapping("/loan")
    @ResponseStatus(HttpStatus.OK)
    public LoanDetails postUserLoanDetails(@RequestBody UserDetails userDetails){
        try{
            LoanDetails result = (LoanDetails) ruleEngine.run(loanInferenceEngine, userDetails);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
