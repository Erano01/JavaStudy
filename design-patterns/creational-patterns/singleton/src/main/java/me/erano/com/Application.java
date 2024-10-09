package me.erano.com;

import me.erano.com.example1.EagerRegistry;
import me.erano.com.example2.LazyRegistryWithDCL;
import me.erano.com.example3.LazyRegistryHolderIdiom;
import me.erano.com.example4.RegistryEnum;

public class Application {

	public static void main(String[] args) {
		
//		ex1
		EagerRegistry eagerRegistry1 = EagerRegistry.getInstance();
		EagerRegistry eagerRegistry2 = EagerRegistry.getInstance();
		System.out.println(eagerRegistry1==eagerRegistry2);
		
//		ex2
		LazyRegistryWithDCL lazySingleton1 = LazyRegistryWithDCL.getInstance();
		LazyRegistryWithDCL lazySingleton2 = LazyRegistryWithDCL.getInstance();
		System.out.println(lazySingleton1 == lazySingleton2);
	
//		ex3
		LazyRegistryHolderIdiom lazyHolderIdiom1 = LazyRegistryHolderIdiom.getInstance();
		LazyRegistryHolderIdiom lazyHolderIdiom2 = LazyRegistryHolderIdiom.getInstance();
		System.out.println(lazyHolderIdiom1 == lazyHolderIdiom2);
	
//		ex4
		RegistryEnum singletonEnum1 = RegistryEnum.INSTANCE;
		RegistryEnum singletonEnum2 = RegistryEnum.INSTANCE;
		System.out.println(singletonEnum1 == singletonEnum2);
		
//		java.lang.Runtime class in standard java API is a singleton example
		//currentRuntime ve getRuntime() inceleyin
		Runtime runtime;
	}
}
