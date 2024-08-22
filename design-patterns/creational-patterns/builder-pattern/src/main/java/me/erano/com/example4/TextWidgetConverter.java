package me.erano.com.example4;

import java.awt.Font;

import me.erano.com.example4.product.TextWidget;

//Concrete Builder
public class TextWidgetConverter implements TextConverter{

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

	public TextWidget getTextWidget() {
		return new TextWidget();
	}
	
}
