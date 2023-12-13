package com.kata.series.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "holidays")
public class Holiday {
	@Id
	private String day;
	private String reason;
	@Enumerated(EnumType.STRING)
	private TYPE type;

	public enum TYPE {
		FESTIVAL("This is a General Holiday"), FEDERAL("This Holiday is sactioned by the federal government");

		private String description;

		TYPE(String description) {
			this.description = description;
		}
	}

}
