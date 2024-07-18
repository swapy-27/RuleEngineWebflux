package com.swapnil.ruleEngine.repository;

import com.swapnil.ruleEngine.model.RuleDbModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RuleRepository extends ReactiveCrudRepository<RuleDbModel,String> {

   Flux<RuleDbModel> findAllByRuleNamespace(String namespace);

}
