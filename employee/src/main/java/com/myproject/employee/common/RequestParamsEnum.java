package com.myproject.employee.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum RequestParamsEnum {

	NAME("name"), AGE("age"), SALARY("salary");

	private String value;

	private RequestParamsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static List<String> getValues()
	{
		List<String> vals = new ArrayList<>();
		Arrays.asList(RequestParamsEnum.values()).stream().forEach(x -> vals.add(x.value));
		return vals;
	}

}
