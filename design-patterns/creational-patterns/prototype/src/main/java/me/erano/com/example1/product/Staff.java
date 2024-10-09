package me.erano.com.example1.product;

//Concrete Product
public class Staff implements Graphic{

	@Override
	public Staff clone() throws CloneNotSupportedException {
        return (Staff)super.clone();
	}
	
	@Override
    public String toString() {
        return "Staff";
    }
}
