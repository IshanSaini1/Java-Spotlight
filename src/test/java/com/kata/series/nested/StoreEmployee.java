package com.kata.series.nested;

import java.util.Comparator;
import java.util.List;

public class StoreEmployee extends Employee {
	private String store;

	public StoreEmployee(Integer employeeId, String name, Integer yearStarted, String store) {
		super(employeeId, name, yearStarted);
		this.store = store;
	}

	public StoreEmployee() {
		super();
		this.store = "Retailer";
	}

	 class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee> {

		@Override
		public int compare(StoreEmployee o1, StoreEmployee o2) {
			int result = o1.store.compareTo(o2.store);
			if (result == 0) {
				return new Employee.EmployeeComparator<>("id").compare(o1, o2);
			}
			return result;
		}

	}

	@Override
	public String toString() {
		return "StoreEmployee [store=" + store + ", employeeId=" + employeeId + ", name=" + name + ", yearStarted="
				+ yearStarted + "]";
	}

}
