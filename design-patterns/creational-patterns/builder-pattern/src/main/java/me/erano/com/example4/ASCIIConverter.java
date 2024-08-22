package me.erano.com.example4;

import java.awt.Font;

import me.erano.com.example4.product.ASCIIText;

//Concrete Builder
public class ASCIIConverter implements TextConverter{

	@Override
	public void convertCharacter(char c) {
		
	}

	@Override
	public void convertFontChange(Font font) {
		
	}

	@Override
	public void convertParagraph() {
		
	}
	
	public ASCIIText getASCIIText(){
		return new ASCIIText();
	}

	
}
