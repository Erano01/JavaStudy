package me.erano.com.example4;

import java.awt.Font;

import me.erano.com.example4.product.TeXText;

//Concrete Builder
public class TeXConverter implements TextConverter{

	@Override
	public void convertCharacter(char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertFontChange(Font font) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertParagraph() {
		// TODO Auto-generated method stub
		
	}

	public TeXText getTeXText() {
		return new TeXText();
	}
	
}
