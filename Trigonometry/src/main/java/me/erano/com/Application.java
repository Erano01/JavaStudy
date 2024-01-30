package me.erano.com;

import java.util.Vector;

public class Application {

	public static void main(String[] args) {
		
		//birim çemberde :
		//cos değeri x koordinatı değerlerini değiştirir.
		//sin değeri y koordinatı değerlerini değiştirir.
		
		//cos 1.0 to cos -1.0  -> 0 degree and 180 degree
		//sin 1.0 to sin -1.0 ->  90 degree and 270 degree
		double radian = Math.toRadians(270);
		
		double sin = Math.sin(radian);
		double cos = Math.cos(radian);
		
		System.out.println("Sin value : "+sin);
		System.out.println("Cos value : "+cos);
		
		
 	}
}
