package me.erano.com.example3.implementator;

//Abstract Implementator
public abstract class Pizza {

    protected String sauce;
    protected String toppings;
    protected String crust;

    public abstract void assemble();
    public abstract void qualityCheck();
	public String getSauce() {
		return sauce;
	}
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	public String getToppings() {
		return toppings;
	}
	public void setToppings(String toppings) {
		this.toppings = toppings;
	}
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}

    
}
