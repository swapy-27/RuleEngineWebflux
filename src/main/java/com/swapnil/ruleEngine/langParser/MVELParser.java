package com.swapnil.ruleEngine.langParser;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.mvel2.MVEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
@Slf4j
@Service
public class MVELParser {



    public boolean parseMvelExpression(String expression, Map<String, Object> inputObjects) {
        try {
            return MVEL.evalToBoolean(expression, inputObjects);
        } catch (Exception e) {
            log.error("Can not parse Mvel Expression : {} Error: {}", expression, e.getMessage());
        }
        return false;
    }
}