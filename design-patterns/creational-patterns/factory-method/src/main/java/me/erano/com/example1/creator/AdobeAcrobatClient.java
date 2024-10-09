package me.erano.com.example1.creator;

import me.erano.com.example1.product.Document;
import me.erano.com.example1.product.PDFDocument;

public class AdobeAcrobatClient extends Client{

	//Overriding factory method
	@Override
	public Document createDocument() {
		return new PDFDocument();
	}
	
}
