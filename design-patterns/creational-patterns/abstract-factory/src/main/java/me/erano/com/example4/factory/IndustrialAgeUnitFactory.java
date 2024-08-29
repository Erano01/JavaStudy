package me.erano.com.example4.factory;

import me.erano.com.example4.product.Ironclad;
import me.erano.com.example4.product.LandUnit;
import me.erano.com.example4.product.NavalUnit;
import me.erano.com.example4.product.Rifleman;

public class IndustrialAgeUnitFactory extends UnitFactory{

	@Override
	public NavalUnit createNavalUnit() {
		return new Ironclad();
	}

	@Override
	public LandUnit createLandUnit() {
		return new Rifleman();
	}

	
}
