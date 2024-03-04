package me.erano.com.streamapi.s01introduction;

import java.time.LocalDate;
import java.util.Objects;

public class Sale {
	
	private String product;
    private LocalDate date;
    private int amount;
    
	public Sale(String product, LocalDate date, int amount) {
		super();
		this.product = product;
		this.date = date;
		this.amount = amount;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, date, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return amount == other.amount && Objects.equals(date, other.date) && Objects.equals(product, other.product);
	}
	

    
}
