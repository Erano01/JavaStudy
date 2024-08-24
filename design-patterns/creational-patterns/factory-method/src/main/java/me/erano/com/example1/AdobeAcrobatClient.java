package me.erano.com.example1;

public class AdobeAcrobatClient extends Client{

	//Overriding factory method
	@Override
	public Document createDocument() {
		return new PDFDocument();
	}
	
}
