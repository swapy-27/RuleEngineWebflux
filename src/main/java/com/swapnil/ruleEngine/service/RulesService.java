package com.swapnil.ruleEngine.service;

import com.swapnil.ruleEngine.model.Rule;
import com.swapnil.ruleEngine.model.RuleDbModel;
import com.swapnil.ruleEngine.model.RuleNamespace;
import com.swapnil.ruleEngine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class RulesService {

    @Autowired
    private RuleRepository rulesRepository;


    public Flux<Rule> getAllRules() {
        return rulesRepository.findAll().map(this::convertRuleDBToRule);
    }
    public  Flux<Rule> getAllRuleByNamespace( String ruleNamespace ) {
        return rulesRepository.findAllByRuleNamespace(ruleNamespace).map(this::convertRuleDBToRule);
    }

    Rule convertRuleDBToRule(RuleDbModel Rule) {

        return new Rule(RuleNamespace.valueOf(Rule.getRuleNamespace()), Rule.getRuleId(), Rule.getCondition(), Rule.getAction(), Rule.getPriority(), Rule.getDescription());
    }

    RuleDbModel convertRuleToRuleDB(Rule rule) {
        return new RuleDbModel(rule.getRuleNamespace().toString(), rule.getRuleId(), rule.getCondition(), rule.getAction(), rule.getPriority(), rule.getDescription());
    }

}
