package com.swapnil.ruleEngine.dslResolver;

public class BankResolver implements DSLResolver{

    private static final String RESOLVER_KEYWORD = "bank";
    private static final String INTEREST = "interest";
    private static final String TARGET_DONE = "target_done";


    @Override
    public String getResolverKeyword() {
        return RESOLVER_KEYWORD;
    }

    @Override
    public Object resolveValue(String keyword) {

        if(keyword.equals(INTEREST)){
            return 9.0;
        }

        if(keyword.equals(TARGET_DONE)){
            return false;
        }
        return null;
    }
}
