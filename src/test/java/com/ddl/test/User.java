package com.ddl.test;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class User {

	private String userName;

	private String addr;

	private int age;

	private List<Girlfriend> girlfriends = new ArrayList<>();

	@Data
	public class Girlfriend {

		private String girlName;

		private int girlAge;

		private String girlAddr;
	}
}
