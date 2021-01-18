package com.aws.codestar.projecttemplates.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aws.codestar.projecttemplates.service.DataProtector;
import com.aws.codestar.projecttemplates.service.aws.LambdaInvoker;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DataProtectorImpl implements DataProtector {
	@Autowired
	private LambdaInvoker lambdaInvoker;
	@Override
	public String transform(String clearValue, String dataElementName, String userId) {
		String returnValue=lambdaInvoker.invokeTransformLambda();
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,String> myMap = new HashMap<String, String>();
		byte[] mapData = returnValue.getBytes();
		try {
			myMap = objectMapper.readValue(mapData, HashMap.class);
			returnValue=myMap.get("message");
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnValue;//comment
	}

}
