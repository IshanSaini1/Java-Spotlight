package com.kata.series.kafka.modules.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private String employeeId;
	private String name;
	private LocalDate birthDate;
}
