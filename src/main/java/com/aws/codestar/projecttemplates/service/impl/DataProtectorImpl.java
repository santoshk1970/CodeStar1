package com.aws.codestar.projecttemplates.service.impl;

import org.springframework.stereotype.Component;

import com.aws.codestar.projecttemplates.service.DataProtector;

@Component
public class DataProtectorImpl implements DataProtector {

	@Override
	public String transform(String clearValue, String dataElementName, String userId) {
		return clearValue.concat("transformed");//comment
	}

}
