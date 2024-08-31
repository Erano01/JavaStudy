package me.erano.com.example2;

import javax.management.InstanceAlreadyExistsException;

import me.erano.com.example1.EagerRegistry;

public class LazyRegistryWithDCL {

	private LazyRegistryWithDCL() {
		//we cannot inherit this class when its constructor is private.
	}
	//volatile forces value read/write from main memory instead of cache.
	private static volatile LazyRegistryWithDCL INSTANCE;
	
	public static LazyRegistryWithDCL getInstance() {
		// we have to double check that is object null, because 
		//first checking is stands for we need to make sure that there is no instance already present
		//second checking is stands for synchronizing issues, that means if 2 threads call this method 
		//simultaneosly(at the same time) then if we dont use any kind of synchronization mechanism, 
		//then we will end up with creating two different instance of this class and we want to avoid it. 
		if (INSTANCE == null) {
			synchronized (LazyRegistryWithDCL.class) {
				if (INSTANCE == null) {
					INSTANCE = new LazyRegistryWithDCL();
				}
			}
		}
		return INSTANCE;
	}
}