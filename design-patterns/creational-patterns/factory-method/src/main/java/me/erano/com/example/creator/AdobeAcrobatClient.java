package me.erano.com.example.creator;

import me.erano.com.example.product.Document;
import me.erano.com.example.product.PDFDocument;

public class AdobeAcrobatClient extends Client{

	//Overriding factory method
	@Override
	public Document createDocument() {
		return new PDFDocument();
	}
	
}
