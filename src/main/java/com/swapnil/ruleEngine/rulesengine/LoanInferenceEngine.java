package com.swapnil.ruleEngine.rulesengine;

import com.swapnil.ruleEngine.model.LoanDetails;
import com.swapnil.ruleEngine.model.RuleNamespace;
import com.swapnil.ruleEngine.model.UserDetails;

import com.swapnil.ruleEngine.rulesengine.InferenceEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoanInferenceEngine extends InferenceEngine
        <UserDetails, LoanDetails> {

    @Override
    protected RuleNamespace getRuleNamespace() {
        return RuleNamespace.LOAN;
    }

    @Override
    protected LoanDetails initializeOutputResult() {
        return LoanDetails.builder().build();
    }
}