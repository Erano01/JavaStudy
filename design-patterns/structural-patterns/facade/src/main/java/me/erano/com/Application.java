package me.erano.com;

import me.erano.com.example2.EmailFacade;
import me.erano.com.example2.Order;
import me.erano.com.example3.BuyCryptoFacade;

public class Application {

	public static void main(String[] args) {
		
//		ex1


//		ex2
		Order order = new Order("101", 99.99);
		EmailFacade facade = new EmailFacade();

		boolean result = facade.sendOrderEmail(order);

		System.out.println("Order Email "+ (result?"sent!":"NOT sent..."));


//		ex3
		BuyCryptoFacade buyCrypto = new BuyCryptoFacade();
		buyCrypto.buyCryptocurrency(1000, "BTC");

//		java api facade example is java.net.URL, look at the URL.openStream method
		
	}
}
