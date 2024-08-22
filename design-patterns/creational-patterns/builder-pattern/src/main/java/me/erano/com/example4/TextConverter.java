package me.erano.com.example4;

import java.awt.Font;

//this is our builder interface
public interface TextConverter {

	void convertCharacter(char c);
	
	void convertFontChange(Font font);
	
	void convertParagraph();
}
