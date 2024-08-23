package me.erano.com.example4;

import java.awt.Font;

import me.erano.com.example4.product.ASCIIText;

//Concrete Builder
//ASCIIConverter with font change handling
public class ASCIIConverter implements TextConverter {
	private ASCIIText asciiText = new ASCIIText();

	@Override
	public void convertCharacter(char c) {
		asciiText.append(c);
	}

	@Override
	public void convertParagraph() {
		asciiText.appendParagraph();
	}

	@Override
	public void convertFontChange(String font) {
		// ASCII conversion ignores font changes
	}

	@Override
	public ASCIIText getResult() {
		return asciiText;
	}
}
