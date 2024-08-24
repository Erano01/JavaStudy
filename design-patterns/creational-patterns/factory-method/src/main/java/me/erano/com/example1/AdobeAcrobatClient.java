package me.erano.com.example1;

public class AdobeAcrobatClient implements Client{

	//Overriding factory method
	@Override
	public Document createDocument() {
		return new PDFDocument();
	}
	
}
