package net.amznsantosh.transform.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.amznsantosh.transform.model.DataToBeProtected;

public interface DataProtector {
public String transform(String clearValue, String dataElementName,String userId );

public String transform(DataToBeProtected dataToBeProtected) throws JsonProcessingException;
}
