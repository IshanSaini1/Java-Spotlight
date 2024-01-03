package com.kata.series.delete;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParException extends Exception{
	
	public ParException(Exception e) {
		super(e.getLocalizedMessage(), e);
		log.warn("In Parent Class : Rollback Here");
	}

}
