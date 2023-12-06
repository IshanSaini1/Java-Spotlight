package com.kata.series.e1.aspects.objects;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Profile("NO_BOOT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Division {
	private String div_class;
	private Integer div_int;
}
