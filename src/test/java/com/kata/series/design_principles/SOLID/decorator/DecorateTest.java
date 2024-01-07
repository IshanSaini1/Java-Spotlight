package com.kata.series.design_principles.SOLID.decorator;

interface ChristmasTree {
	String decorate();
}

class ChristmasTreeImpl implements ChristmasTree {

	@Override
	public String decorate() {
		return "Christmas tree";
	}
}

abstract class TreeDecorator implements ChristmasTree {
	private ChristmasTree tree;

	public TreeDecorator(ChristmasTree tree) {
		this.tree = tree;
	}

	@Override
	public String decorate() {
		return tree.decorate();
	}
}

public class DecorateTest {

}
