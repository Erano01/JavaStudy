package me.erano.com.example5.factory;

import me.erano.com.example5.product.Ec2Instance;
import me.erano.com.example5.product.Instance;
import me.erano.com.example5.product.S3Storage;
import me.erano.com.example5.product.Instance.Capacity;
import me.erano.com.example5.product.Storage;

public class AwsResourceFactory extends ResourceFactory{

	@Override
	public Instance createInstance(Capacity capacity) {
		return new Ec2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capacityMib) {
		return new S3Storage(capacityMib);
	}

	
}
