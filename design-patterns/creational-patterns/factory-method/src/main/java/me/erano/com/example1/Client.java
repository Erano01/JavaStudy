package me.erano.com.example1;

//Abstract Creator
public interface Client {
	
	//factory method
	Document createDocument();

	default void openDocument(Document document) {
		document.open();
	}
	
	default Document newDocument() {
		return createDocument();
	}
	
}
