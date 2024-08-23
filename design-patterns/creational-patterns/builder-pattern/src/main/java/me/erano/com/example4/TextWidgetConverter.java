package me.erano.com.example4;

import me.erano.com.example4.product.TextWidget;

//Concrete Builder
public class TextWidgetConverter implements TextConverter {
	private TextWidget textWidget = new TextWidget();

	@Override
	public void convertCharacter(char c) {
		textWidget.append(c);
	}

	@Override
	public void convertParagraph() {
		textWidget.appendParagraph();
	}

	@Override
	public void convertFontChange(String font) {
		textWidget.append(String.format("[Font:%s]", font)); // Simplified handling
	}

	@Override
	public TextWidget getResult() {
		return textWidget;
	}
}
