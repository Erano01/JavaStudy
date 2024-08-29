package me.erano.com.example4.factory;

import me.erano.com.example4.product.Galley;
import me.erano.com.example4.product.LandUnit;
import me.erano.com.example4.product.NavalUnit;
import me.erano.com.example4.product.Swordsman;

public class MedievalUnitFactory extends UnitFactory{

	@Override
	public NavalUnit createNavalUnit() {
		return new Galley();
	}

	@Override
	public LandUnit createLandUnit() {
		return new Swordsman();
	}

	
}
