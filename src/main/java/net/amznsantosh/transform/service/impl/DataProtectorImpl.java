package net.amznsantosh.transform.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.amznsantosh.transform.model.DataToBeProtected;
import net.amznsantosh.transform.service.DataProtector;
import net.amznsantosh.transform.service.aws.LambdaInvoker;

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
	@Override
	public String transform(DataToBeProtected dataToBeProtected) throws JsonProcessingException {
		String returnValue=lambdaInvoker.invokeTransformLambda(dataToBeProtected);
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
