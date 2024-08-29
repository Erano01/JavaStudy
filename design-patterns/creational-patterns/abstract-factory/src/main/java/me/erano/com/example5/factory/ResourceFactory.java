package me.erano.com.example5.factory;

import me.erano.com.example5.product.Instance;
import me.erano.com.example5.product.Instance.Capacity;
import me.erano.com.example5.product.Storage;

public abstract class ResourceFactory {

	public abstract Instance createInstance(Capacity capacity);
	public abstract Storage createStorage(int capacityMib);
}
