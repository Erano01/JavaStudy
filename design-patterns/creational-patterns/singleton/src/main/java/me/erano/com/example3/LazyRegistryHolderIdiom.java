package me.erano.com.example3;

//lazy initialization holder idiom.
// inventor : Bill Pugh
public class LazyRegistryHolderIdiom {

	private LazyRegistryHolderIdiom() {
		System.out.println("In LazyRegistryHolderIdiom created");
	}
	
	//singleton helper class. this is thread-safe
	private static class RegistryHolder{
		static LazyRegistryHolderIdiom INSTANCE = new LazyRegistryHolderIdiom();
	}
	
	public static LazyRegistryHolderIdiom getInstance() {
		return RegistryHolder.INSTANCE;
	}
}
