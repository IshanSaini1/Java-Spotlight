package com.kata.series.delete;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChildException extends ParException {

	private static final long serialVersionUID = -6638488565588103074L;

	public ChildException(Exception e) {
		super(e);
		log.warn("In Child : Dont RollBack Here");
	}

}
