package com.aws.codestar.projecttemplates.service.impl;

import com.aws.codestar.projecttemplates.service.DataProtector;

public class DataProtectorImpl implements DataProtector {

	@Override
	public String transform(String clearValue, String dataElementName, String userId) {
		return clearValue.concat("transformed");
	}

}
