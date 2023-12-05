package com.kata.series.e1.aspects.objects;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Division {
	private String div_class;
	private Integer div_int;
}
