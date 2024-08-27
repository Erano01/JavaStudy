package me.erano.com.example3;

import me.erano.com.example3.product.JSONMessage;
import me.erano.com.example3.product.Message;

//Concrete Creator
public class JSONMessageCreator extends MessageCreator{

	@Override
	protected Message createMessage() {
		return new JSONMessage();
	}

	
}
