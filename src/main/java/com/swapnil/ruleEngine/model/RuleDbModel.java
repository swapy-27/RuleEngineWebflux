package com.swapnil.ruleEngine.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;


@Table(name = "rules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleDbModel {
    @Id
    @Column(value  = "rule_namespace")
    private String ruleNamespace;
    @Column(value = "rule_id")
    private String ruleId;
    @Column(value = "condition")
    private String condition;
    @Column(value = "action")
    private String action;
    @Column(value = "priority")
    private Integer priority;
    @Column(value = "description")
    private String description;
    @Data
    static class IdClass implements Serializable {
        private String ruleNamespace;
        private String ruleId;
    }
}