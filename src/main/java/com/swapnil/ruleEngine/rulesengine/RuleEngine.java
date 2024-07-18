package com.swapnil.ruleEngine.rulesengine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.cache.Cache;
import com.swapnil.ruleEngine.model.Rule;
import com.swapnil.ruleEngine.rulesengine.InferenceEngine;
import com.swapnil.ruleEngine.service.RulesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RuleEngine {

    @Autowired
    private RulesService knowledgeBaseService;

    public Object run(InferenceEngine inferenceEngine, Object inputData) throws ExecutionException {
        String ruleNamespace = inferenceEngine.getRuleNamespace().toString();
        //TODO: Here for each call, we are fetching all rules from db. It should be cache.
        // Assume allRulesByNamespace is your Flux<List<Rule>>
// Initialize your cache
        com.github.benmanes.caffeine.cache.Cache<String, List<Rule>> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();



// Fetch rules from the cache or database
        List<Rule> ruleList = cache.get(ruleNamespace, k -> {
            try {
                return knowledgeBaseService.getAllRuleByNamespace(ruleNamespace)
                        .collectList()
                        .subscribeOn(Schedulers.boundedElastic())
                        .block();
            } catch (Exception e) {
                // Handle exception and rethrow if necessary
                throw new RuntimeException("Failed to collect rules", e);
            }
        });

        Object result = inferenceEngine.run(ruleList, inputData);
        return result;
    }

}