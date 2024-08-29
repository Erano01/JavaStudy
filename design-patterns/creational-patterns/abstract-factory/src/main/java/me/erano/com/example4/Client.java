package me.erano.com.example4;

import me.erano.com.example4.factory.UnitFactory;
import me.erano.com.example4.product.LandUnit;
import me.erano.com.example4.product.NavalUnit;

public class Client {

	private LandUnit landUnit;
	private NavalUnit navalUnit;
	
	public Client(UnitFactory unitFactory) {
		this.landUnit=unitFactory.createLandUnit();
		this.navalUnit=unitFactory.createNavalUnit();
	}
	
	public void renderGame() {
        landUnit.walk();
        navalUnit.swim();
    }
}
