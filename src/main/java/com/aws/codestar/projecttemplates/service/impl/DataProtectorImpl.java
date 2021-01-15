package com.aws.codestar.projecttemplates.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aws.codestar.projecttemplates.service.DataProtector;
import com.aws.codestar.projecttemplates.service.aws.LambdaInvoker;

@Component
public class DataProtectorImpl implements DataProtector {
	@Autowired
	private LambdaInvoker lambdaInvoker;
	@Override
	public String transform(String clearValue, String dataElementName, String userId) {
		String returnValue=lambdaInvoker.invokeTransformLambda();
		return clearValue.concat("transformed"+returnValue);//comment
	}

}
