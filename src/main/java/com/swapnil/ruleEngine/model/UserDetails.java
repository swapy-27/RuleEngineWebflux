package com.swapnil.ruleEngine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    String firstName;
    String lastName;
    Integer age;
    Long accountNumber;
    Double monthlySalary;
    String bank;
    Integer cibilScore;
    Double requestedLoanAmount;

}