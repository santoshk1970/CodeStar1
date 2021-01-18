package net.amznsantosh.transform.service.aws;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.amznsantosh.transform.model.DataToBeProtected;

public interface LambdaInvoker {
public String invokeTransformLambda();

public String invokeTransformLambda(DataToBeProtected dataToBeProtected) throws JsonProcessingException;
}
