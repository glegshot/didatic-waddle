package org.example;

import com.amazonaws.services.lambda.runtime.Context;

public class Handler{

    public String handleRequest(String input, Context context){

        context.getLogger().log("Input: " + input );
        return "Hello " + input + " You did it bruh !! you did it :)";
    }

}
