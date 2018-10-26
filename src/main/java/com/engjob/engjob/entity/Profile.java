package com.engjob.engjob.entity;

public enum Profile {

	ADMIN     ("ADMIN", "Admin of EngJob"),
	APPLICANT ("APPLICANT", "Applicant of EngJob"),
	EMPLOYER  ("EMPLOYER", "Employer of EngJob");

	private final String code;
	private final String description;


	private Profile(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
