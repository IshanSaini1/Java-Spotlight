package com.kata.series.design_principles.SOLID.adapter;

// Interface Charger
interface Charger {
	public void charge();
}

//Interface Phone
interface IPhone {
	public void OnCharge();
}

//Charger for Iphone 4S
class Iphone4Charger implements Charger {
	public Iphone4Charger() {

	}

	public void charge() {
		System.out.println("charging with 4s charger");
	}
}

//Adapter
class Iphone4sTo6sChargerAdapter implements Charger {
	Iphone4Charger iphone4sCharger;

	Iphone4sTo6sChargerAdapter() {
		iphone4sCharger = new Iphone4Charger();
	}

	@Override
	public void charge() {
		iphone4sCharger.charge();
	}
}

//Iphone 6
class IPhone6s implements IPhone {
	Charger Iphone4sTo6sAdapter;

	public IPhone6s(Charger iphone4sTo6sAdapter) {
		this.Iphone4sTo6sAdapter = iphone4sTo6sAdapter;
	};

	@Override
	public void OnCharge() {
		Iphone4sTo6sAdapter.charge();
	}
}

public class AdapterPattern {
	public static void main(String args[]) {
		IPhone6s iphone6s = new IPhone6s(new Iphone4sTo6sChargerAdapter());
		iphone6s.OnCharge();
	}
}
