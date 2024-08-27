package me.erano.com.example3;

import me.erano.com.example3.product.Message;

//Abstract Creator
public abstract class MessageCreator {

	//factory method
	protected abstract Message createMessage();
	
	public Message getMessage() {
		Message msg = createMessage();
		msg.addDefaultHeaders();
		msg.encrypt();
		return msg;
	}
	
	
	
}
