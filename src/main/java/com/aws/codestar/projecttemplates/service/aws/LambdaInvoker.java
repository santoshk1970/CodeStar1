package com.aws.codestar.projecttemplates.service.aws;

import com.aws.codestar.projecttemplates.model.DataToBeProtected;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface LambdaInvoker {
public String invokeTransformLambda();

public String invokeTransformLambda(DataToBeProtected dataToBeProtected) throws JsonProcessingException;
}
