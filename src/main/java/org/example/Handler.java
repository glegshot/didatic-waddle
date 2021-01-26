package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class Handler implements RequestHandler<Map<String, String>, Integer> {

    @Override
    public Integer handleRequest(Map<String, String> input, Context context) {

        context.getLogger().log("welcome to lambda");
        for (Map.Entry e : input.entrySet()) {
            context.getLogger().log(e.getKey() + ":" + e.getValue());
        }

        return input.entrySet().size();

    }
}
