package com.kata.series.design_principles.SOLID.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
class Employee {

	private Employee(int id, String name, Integer mobileNumber) {
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	public Employee() {

	}

	private int id;
	private String name;
	private int mobileNumber;

	public static EmpBuilder builder() {
		return new EmpBuilder();
	}

	public static class EmpBuilder {

		private int id;
		private String name;
		private int mobileNumber;

		public EmpBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public EmpBuilder name(String name) {
			this.name = name;
			return this;
		}

		public EmpBuilder mobile(Integer mobile) {
			this.mobileNumber = mobile;
			return this;
		}

		public Employee build() {
			return new Employee(this.id, this.name, this.mobileNumber);
		}
	}
}

class EmployeeBuilder {
	private Employee employee;

	public EmployeeBuilder builder() {
		this.employee = new Employee();
		return this;
	}

	public EmployeeBuilder id(Integer id) {
		this.employee.setId(id);
		return this;
	}

	public EmployeeBuilder name(String name) {
		this.employee.setName(name);
		return this;
	}

	public EmployeeBuilder mobileNumber(Integer mobileNumber) {
		this.employee.setMobileNumber(mobileNumber);
		return this;
	}

	public Employee build() {
		return this.employee;
	}

}

public class BuilderPattern {
	public static void main(String args[]) {
		Employee e1 = new EmployeeBuilder().builder().id(1).name("Ishan").mobileNumber(123456789).build();
		Employee e2 = new EmployeeBuilder().builder().id(2).name("Saini").mobileNumber(125324342).build();
		System.out.println(e1);
		System.out.println(e2);
		Employee e3 = Employee.builder().id(3).name("I1").mobile(12344342).build();
		Employee e4 = Employee.builder().id(4).name("I2").mobile(11223342).build();
		System.out.println(e3);
		System.out.println(e4);
	}

}
