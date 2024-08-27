package me.erano.com.example3;

import me.erano.com.example3.product.Message;
import me.erano.com.example3.product.TextMessage;

//Concrete Creator
public class TextMessageCreator extends MessageCreator{

	@Override
	protected Message createMessage() {
		return new TextMessage();
	}

	
}
