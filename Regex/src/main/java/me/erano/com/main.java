package me.erano.com;

import java.util.ArrayList;
import java.util.List;


public class main {

	public static void main(String[] args) {
		System.out.println("Started");
		String asd = "John max doe, Chad Darby, isim1 isim2 isim3 soyad";
		List<Personal> personals = seperatePersonalsFromText(asd);
		for(Personal personal : personals) {
			System.out.println(personal.getName()+" "+personal.getLastName());
		}
	}

	
	public static List<Personal> seperatePersonalsFromText(String data) {
		List<Personal> personals = new ArrayList<>();
		// (john max doe) ( chad darby) aldık
		String[] namePairs = data.split(",");
		for (String namePair : namePairs) {
			// (john)(max)(doe)
			String firstName = "";
			String lastName = "";
			String[] names = namePair.trim().split("\\s+");
			for(int i = 0; i<names.length; i++) {
				if(i!=names.length-1) {
					if(i!=0) {
						firstName += " "+names[i];
						continue;
					}
					firstName += names[i]; 
					continue;
				}
				lastName+=names[i];
			}
			personals.add(new Personal(firstName,lastName));
		}
		return personals;
	}
}
