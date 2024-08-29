package me.erano.com.example5.product;

public class GoogleComputeEngineInstance implements Instance{

	public GoogleComputeEngineInstance(Capacity capacity) {
		System.out.println("Created Google Compute Engine Instance");
	}
	
	@Override
	public void start() {
		System.out.println("GoogleComputeEngineInstance started");
		
	}

	@Override
	public void stop() {
		System.out.println("GoogleComputeEngineInstance stopped");
	}

	@Override
	public void attachStorage(Storage storage) {
		System.out.println("Attached "+storage+" to GoogleComputeEngineInstance");
	}

	@Override
	public String toString() {
		return "GoogleComputeEngineInstance";
	}

	
	
}
