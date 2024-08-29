package me.erano.com.example5;

import me.erano.com.example5.factory.ResourceFactory;
import me.erano.com.example5.product.Instance;
import me.erano.com.example5.product.Storage;

public class Client {

	private ResourceFactory resourceFactory;
	
	public Client(ResourceFactory resourceFactory) {
		this.resourceFactory = resourceFactory;
	}
	
	public Instance createServer(Instance.Capacity cap, int storageMib) {
		Instance instance = resourceFactory.createInstance(cap);
		Storage storage = resourceFactory.createStorage(storageMib);
		instance.attachStorage(storage);
		return instance;
	}
	
}
