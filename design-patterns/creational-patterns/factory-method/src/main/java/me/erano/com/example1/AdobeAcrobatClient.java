package me.erano.com.example1;

public class AdobeAcrobatClient implements Client{

	@Override
	public Document createDocument() {
		return new PDFDocument();
	}
	
}
