package me.erano.com.example5.factory;

import me.erano.com.example5.product.GoogleCloudStorage;
import me.erano.com.example5.product.GoogleComputeEngineInstance;
import me.erano.com.example5.product.Instance;
import me.erano.com.example5.product.Instance.Capacity;
import me.erano.com.example5.product.Storage;

public class GoogleCloudResourceFactory extends ResourceFactory{

	@Override
	public Instance createInstance(Capacity capacity) {
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capacityMib) {
		return new GoogleCloudStorage(capacityMib);
	}

	
}
