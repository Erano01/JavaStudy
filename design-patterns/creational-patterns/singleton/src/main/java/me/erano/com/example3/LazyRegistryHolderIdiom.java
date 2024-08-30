package me.erano.com.example3;

public class LazyRegistryHolderIdiom {

	//lazy initialization holder idiom.
	
	private LazyRegistryHolderIdiom() {
		System.out.println("In LazyRegistryHolderIdiom created");
	}
	
	private static class RegistryHolder{
		static LazyRegistryHolderIdiom INSTANCE = new LazyRegistryHolderIdiom();
	}
	
	public static LazyRegistryHolderIdiom getInstance() {
		return RegistryHolder.INSTANCE;
	}
}
