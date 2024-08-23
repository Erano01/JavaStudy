package me.erano.com.example4;

import java.awt.Font;

import me.erano.com.example4.product.TeXText;

//Concrete Builder
public class TeXConverter implements TextConverter {
    private TeXText texText = new TeXText();

    @Override
    public void convertCharacter(char c) {
        texText.append(c);
    }

    @Override
    public void convertParagraph() {
        texText.appendParagraph();
    }

    @Override
    public void convertFontChange(String font) {
        texText.append(String.format("\\font{%s}", font)); // TeX-specific font handling
    }

    @Override
    public TeXText getResult() {
        return texText;
    }
}
