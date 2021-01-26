package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.example.s3.S3Operations;

import java.io.IOException;
import java.util.Map;

public class Handler implements RequestHandler<Map<String, String>, Integer> {

    @Override
    public Integer handleRequest(Map<String, String> input, Context context) {

        context.getLogger().log("Welcome to lambda\n");
        context.getLogger().log("Event data:\n");

        for (Map.Entry e : input.entrySet()) {
            context.getLogger().log(e.getKey() + ":" + e.getValue() + "\n");
        }

        try {
            S3Operations s3Operations = new S3Operations(context);
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }

        return 0;

    }
}
