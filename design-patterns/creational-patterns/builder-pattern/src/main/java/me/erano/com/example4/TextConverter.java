package me.erano.com.example4;

import java.awt.Font;

//this is our builder interface
public interface TextConverter {

	void convertCharacter(char c);

	void convertParagraph();

	void convertFontChange(String font);

	Object getResult(); // This will return a specific Product type

}
