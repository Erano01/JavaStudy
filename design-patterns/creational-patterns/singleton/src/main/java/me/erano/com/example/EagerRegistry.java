package me.erano.com.example;

public class EagerRegistry {

	private EagerRegistry() {
		//we cannot inherit this class when its constructor is private.
	}
	
	private static final EagerRegistry INSTANCE = new EagerRegistry();

	public static EagerRegistry getInstance() {
		return INSTANCE;
	}
	
}
