package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.model.DataToBeProtected;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface DataProtector {
public String transform(String clearValue, String dataElementName,String userId );

public String transform(DataToBeProtected dataToBeProtected) throws JsonProcessingException;
}
