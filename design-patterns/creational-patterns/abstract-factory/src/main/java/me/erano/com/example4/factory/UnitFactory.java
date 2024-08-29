package me.erano.com.example4.factory;

import me.erano.com.example4.product.LandUnit;
import me.erano.com.example4.product.NavalUnit;

public abstract class UnitFactory {

	public abstract NavalUnit createNavalUnit();
	public abstract LandUnit createLandUnit();
}
