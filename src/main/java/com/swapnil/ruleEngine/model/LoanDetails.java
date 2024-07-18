package com.swapnil.ruleEngine.model;

import lombok.Builder;

@Builder
public class LoanDetails {
    Boolean approvalStatus;
    Float sanctionedPercentage;
    Double processingFees;

}