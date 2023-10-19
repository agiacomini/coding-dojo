package com.giacomini.andrea.arithmetics;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Operation implements IOperation {
    private String operation;
    public Operation(String operation){
        this.operation = operation;
    }
    @Override
    public Double calculate() {
        Double result = 0.0;
        if(!operation.isEmpty()){
            try {
                ScriptEngineManager factory = new ScriptEngineManager();
                ScriptEngine engine = factory.getEngineByName("JavaScript");
                result = Double.parseDouble(engine.eval(operation).toString());
            } catch (ScriptException e){
            }
        }
        return result;
    }
}