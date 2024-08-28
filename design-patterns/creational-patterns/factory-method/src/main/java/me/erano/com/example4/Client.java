package me.erano.com.example4;

import me.erano.com.example4.product.Manipulator;

//Client class that uses both hierarchies
public class Client {
	private Manipulator manipulator;

	public void setManipulator(Manipulator manipulator) {
		this.manipulator = manipulator;
	}

	public void performManipulation() {
		if (manipulator != null) {
			manipulator.downClick();
			manipulator.drag();
			manipulator.upClick();
		} else {
			System.out.println("No manipulator set.");
		}
	}
}
