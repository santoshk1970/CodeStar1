package com.aws.codestar.projecttemplates.service.aws.impl;

import java.nio.charset.StandardCharsets;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;
import com.aws.codestar.projecttemplates.service.aws.LambdaInvoker;

public class LambdaInvokerImpl implements LambdaInvoker{

	@Override
	public String invokeTransformLambda() {
		String functionName = "myHelloWorld";
		String message = "{\n"+"\"first_name\": \"Santosh\",\n"
				+ "\"last_name\": \"Kulkarni\"\n"+
			"}"; 
			    
       // InvokeRequest invokeRequest = new InvokeRequest()
       //         .withFunctionName(functionName)
       //         .withPayload("{\n" +
       //                 " \"key1 \": \"Paris\",\n" +
       //                 " \"key2\": \"FR\"\n" +
       //                 "}");
        InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName(functionName)
                .withPayload(message);
        InvokeResult invokeResult = null;
        String ans= "default";
        try {
            AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(Regions.US_EAST_1).build();

            invokeResult = awsLambda.invoke(invokeRequest);

            ans = new String(invokeResult.getPayload().array(), StandardCharsets.UTF_8);

            //write out the return value
            System.out.println(ans);

        } catch (ServiceException e) {
            System.out.println(e);
        }

        System.out.println(invokeResult.getStatusCode());
		return ans;
	}
}
