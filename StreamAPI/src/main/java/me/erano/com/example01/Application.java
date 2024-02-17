package me.erano.com.example01;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		withoutStreamAPI();
		withStreamAPI();
		
	}
	public static void withStreamAPI() {
        List<Sale> sales = List.of(
                new Sale("Rampage Monitor", LocalDate.of(2001, Month.MARCH, 10), 20),
                new Sale("Razer Keyboard", LocalDate.of(2010, Month.MARCH, 20), 10),
                new Sale("MSI Clutch M8 Mouse", LocalDate.of(2010, Month.DECEMBER, 10), 10)
        );

        int amountSoldInMarch = sales.stream()
                .filter(sale -> sale.getDate().getMonth() == Month.MARCH)
                .mapToInt(Sale::getAmount) //(sale) -> sale.getAmount()
                .sum();

        System.out.println("Amount sold in March (with Stream API): " + amountSoldInMarch);
	}
	
	public static void withoutStreamAPI() {
		List<Sale> sales = List.of(
				new Sale("Rampage Monitor",LocalDate.of(2001, Month.MARCH, 10),20),
				//new Sale("MSI Clutch M8 Mouse",LocalDate.now(),10),
				new Sale("Razer Keyboard",LocalDate.of(2010, Month.MARCH, 20),10),
				new Sale("MSI Clutch M8 Mouse",LocalDate.of(2010, Month.DECEMBER, 10),10)
				);
		//mapping = List<Sale> sales -> int amountSoldInMarch
		int amountSoldInMarch = 0;
		for (Sale sale: sales) {
			//filtering
		    if (sale.getDate().getMonth() == Month.MARCH) {
		    	//sum
		        amountSoldInMarch += sale.getAmount();
		    }
		}
		System.out.println("Amount sold in March (without Stream API): " + amountSoldInMarch);
	}
}
