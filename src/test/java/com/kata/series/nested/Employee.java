package com.kata.series.nested;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Employee {
	protected Integer employeeId;
	protected String name;
	protected Integer yearStarted;

	public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

		private String sortType;

		public EmployeeComparator() {
			this("name");
		}

		public EmployeeComparator(String sortType) {
			this.sortType = sortType;
		}

		@Override
		public int compare(Employee o1, Employee o2) {
			if (sortType.equalsIgnoreCase("yearStarted")) {
				return o1.yearStarted.compareTo(o2.yearStarted);
			} else if (sortType.equalsIgnoreCase("id")) {
				return o1.employeeId.compareTo(o2.employeeId);
			} else {
				return o1.getName().compareTo(o2.getName());
			}
		}
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", yearStarted=" + yearStarted + "]";
	}

}
