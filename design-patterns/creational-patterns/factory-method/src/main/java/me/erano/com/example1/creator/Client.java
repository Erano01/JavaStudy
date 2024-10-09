package me.erano.com.example1.creator;

import me.erano.com.example1.product.Document;

//Abstract Creator -> This can be also interface but protected factory method usage is better implementation.
public abstract class Client {
	
	//factory method -> We must delegate implementations to the sub classes
	//and making factory method protected is better solution for uses of newDocument().
	protected abstract Document createDocument();

	public void openDocument(Document document) {
		document.open();
	}
	
	public Document newDocument() {
		return createDocument();
	}
	
}
